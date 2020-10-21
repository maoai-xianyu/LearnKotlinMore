package net.println.kotlin.chapter06

/**
 *
 * @author zhangkun
 * @time 2020/6/2 3:37 下午
 */
fun html(black: Tag.() -> Unit): Tag {
    return Tag("html").apply {
        black(this)
    }
}

fun Tag.head(black: Head.() -> Unit) {
    this@head.children + Head().apply(black)
}

fun Tag.body(black: Body.() -> Unit) {
    this@body.children.add(Body().apply(black))
}

class StringNode(val content: String) : Node {
    override fun render(): String = content
}

class Head : Tag("head")

class Body : Tag("body") {
    var id by MapDelegate(properties)
    var `class` by MapDelegate(properties)

}