package net.println.kotlinnew.chapter06.dsl

/**
 *
 * @author zhangkun
 * @time 2020/6/2 3:37 下午
 */
fun html(block: BlockNode.() -> Unit): BlockNode {
    val html = BlockNode("html")
    html.block()
    return html
}

fun BlockNode.head(block: BlockNode.() -> Unit): BlockNode {
    val head = BlockNode("head")
    head.block()
    this.children += head
    return head
}

fun BlockNode.body(block: BlockNode.() -> Unit): BlockNode {
    val body = BlockNode("body")
    body.block()
    this.children += body
    return body
}

class StringNode(val content: String) : Node {
    override fun render(): String = content
}
