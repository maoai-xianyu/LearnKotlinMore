package net.println.kotlinnew.chapter06

/**
 *
 * @author zhangkun
 * @time 2020/6/11 3:44 下午
 */

fun main(args: Array<String>) {

    cost {
        val fibonacciNext = fibonacci()
        (0..10).forEach {
            println(fibonacciNext())
        }
    }

}


fun cost(block: () -> Unit) {
    val start = System.currentTimeMillis()
    block()
    println("运行时间 ${System.currentTimeMillis() - start}")
}


// 斐波那契数列
fun fibonacci(): () -> Long {
    var first = 0L
    var second = 1L
    return {
        val next = first + second
        val current = first
        first = second
        second = next
        current
    }
}