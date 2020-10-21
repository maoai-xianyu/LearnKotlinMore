package net.println.kotlin.chapter05

/**
 *
 * @author zhangkun
 * @time 2020/6/2 11:09 上午
 * 尾递归优化
 */
data class ListNode(val value: Int, var next: ListNode? = null)

// 尾递归 优化 tailrec
tailrec fun findListNode(head: ListNode?, value: Int): ListNode? {
    head ?: return null
    if (head.value == value) return head
    return findListNode(head.next, value)
}

fun main(args: Array<String>) {
    val MAX = 10;
    val head = ListNode(0)
    var p = head
    for (i in 1..MAX) {
        p.next = ListNode(i)
        p = p.next!!
    }

    println(findListNode(head, MAX - 2)?.value)
}

// n 的阶乘  不是尾递归
fun factorial(n: Long): Long {
    return n * factorial(n - 1)
}


data class TreeNode(val value: Int) {
    var left: TreeNode? = null  // 左子树
    var right: TreeNode? = null // 右子树
}

// 不是尾递归
fun findTreeNode(root: TreeNode?, value: Int): TreeNode? {
    root ?: return null
    if (root.value == value) return root
    return findTreeNode(root.left, value) ?: return findTreeNode(root.right, value)
}