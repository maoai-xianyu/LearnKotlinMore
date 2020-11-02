package net.println.kotlin.chapter10.regex

import java.util.regex.Pattern

/**
 *
 * @author zhangkun
 * @time 2020/10/22 12:00 上午
 */
fun main(args: Array<String>) {
    val source = "我是中国人，大家好啊。一条龙 010-22200222."
    val pattern = ".*(\\d{3}-\\d{8}).*"
    val matcher = Pattern.compile(pattern).matcher(source)
    while (matcher.find()) {
        println(matcher.group())
        println(matcher.group(1))
    }

    val pattern1 = """.*(\d{3}-\d{8}).*"""
    // kotlin 写法
    Regex(pattern1).findAll(source).toList().flatMap {
        it.groupValues
    }.forEach(::println)
}