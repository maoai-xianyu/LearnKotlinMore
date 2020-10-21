package net.println.kotlinnew.chapter06

/**
 *
 * @author zhangkun
 * @time 2020/6/11 4:32 下午
 */

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4)
    list.flatMap {
        0 until it
    }.joinToString().let(::println)

    list.asSequence().flatMap {
        (0 until it).asSequence()
    }.joinToString().let(::println)

    // 饿汉式
    hugrryfun(list)
    // 懒序列
    //lazyfun(list)
}
private fun hugrryfun(list: List<Int>) {
    list.filter {
            println("filter $it")
            it % 2 == 0
        }
        .map {
            println("map $it")
            it * 2 + 1
        }
        .forEach {
            println("forEach $it")
        }
}

private fun lazyfun(list: List<Int>) {
    list.asSequence()
        .filter {
            println("filter $it")
            it % 2 == 0
        }
        .map {
            println("map $it")
            it * 2 + 1
        }
        .forEach {
            println("forEach $it")
        }
}