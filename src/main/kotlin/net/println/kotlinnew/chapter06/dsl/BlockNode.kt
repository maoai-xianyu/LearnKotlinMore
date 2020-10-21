package net.println.kotlinnew.chapter06.dsl

/**
 *
 * @author zhangkun
 * @time 2020/6/2 3:25 下午
 */

open class BlockNode(val name: String) : Node {

    val children = ArrayList<Node>()
    val properties = HashMap<String, Any>()

    //  "id"("HtmlId")
    operator fun String.invoke(value: Any) {
        this@BlockNode.properties[this] = value
    }

    //"head"{
    //    "id"("headId")
    // }
    operator fun String.invoke(block: BlockNode.() -> Unit): BlockNode {
        val node = BlockNode(this)
        node.block()
        this@BlockNode.children += node
        return node
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
        /* return StringBuilder()
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
             .toString()*/

        return """
            <$name ${properties.map { "${it.key} = '${it.value}'" }.joinToString(" ")}>${children.joinToString("") { it.render() }}</$name>
        """.trimIndent()

    }
}