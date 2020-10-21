package net.println.kotlin.chapter06

import java.lang.StringBuilder

/**
 *
 * @author zhangkun
 * @time 2020/6/2 3:25 下午
 */

open class Tag(val name: String) : Node {

    val children = ArrayList<Node>()
    val properties = HashMap<String, String>()

    //  "id"("HtmlId")
    operator fun String.invoke(value: String) {
        properties[this] = value
    }

    //"head"{
    //    "id"("headId")
    // }
    operator fun String.invoke(block: Tag.() -> Unit) {
        this@Tag.children.add(Tag(this).apply(block))
    }

    /**
     * "body"{
     * "a"{
     * "href"("https://www.coding.cn")
     * +"kotlin 中文博客"
     * }
     * }
     * 的 + 转
     */
    operator fun String.unaryPlus() {
        children.add(StringNode(this))
    }

    /**
     * fun Tag.head(black: Head.() -> Unit) {
     * this@head.children + Head().apply(black)
     * }
     * 的 + 转
     */
    operator fun String.plus(node: Node) {
        children.add(node)
    }

    override fun render(): String {
        return StringBuilder()
            .append("<")
            .append(name)
            .let { stringBuilder ->
                if (this.properties.isNotEmpty()) {
                    stringBuilder.append(" ")
                    this.properties.forEach {
                        stringBuilder.append(it.key)
                            .append("=\"")
                            .append(it.value)
                            .append("\" ")
                    }
                }
                stringBuilder // 返回值
            }
            .append(">")
            .let { stringBuilder ->
                children.map(Node::render).map(stringBuilder::append)
                stringBuilder
            }
            .append("</$name>")
            .toString()
    }
}