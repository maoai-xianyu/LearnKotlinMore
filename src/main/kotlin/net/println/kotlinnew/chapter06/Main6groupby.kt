package net.println.kotlinnew.chapter06

import java.io.File

/**
 *
 * @author zhangkun
 * @time 2020/10/14 2:07 下午
 */

fun main(arg: Array<String>) {

    File("build.gradle").readText()
        .filterNot { it.isWhitespace() }
        .groupBy { it }
        .map {
            it.key to it.value.size
        }.let {
            println(it)
        }

    test("test1","test2","tests")
}
fun test(vararg str: String) {
    str.forEach(::println)
}