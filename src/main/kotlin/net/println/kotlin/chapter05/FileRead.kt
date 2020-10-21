package net.println.kotlin.chapter05

import java.io.File

/**
 *
 * @author zhangkun
 * @time 2020/6/2 3:00 下午
 */

fun main(args: Array<String>) {

    val map = HashMap<Char, Int>()
    File("build.gradle").readText()
        .toCharArray()
        .filterNot{c->c.isWhitespace()}
        .forEach {
            val count = map[it]
            if (count == null) {
                map[it] = 1
            } else {
                map[it] = count + 1
            }
        }

    map.forEach(::println)

    println("--------------")
    File("build.gradle").readText()//读文件
        .toCharArray()// 字符数组
        .filterNot(Char::isWhitespace)// 过滤空白字符
        .groupBy { it } // 分组
        .map { it.key to  it.value.count() }
        .forEach(::println)

}