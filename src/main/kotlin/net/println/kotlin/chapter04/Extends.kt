package net.println.kotlin.chapter04

import java.lang.StringBuilder

/**
 *
 * @author zhangkun
 * @time 2020/5/27 10:25 上午
 */

fun main(args: Array<String>) {

    println("adb".multiply(16))
    println("adb" * 16)

    println("abs".str)
}

/**
 * 一个字符串copy很多遍
 */
fun String.multiply(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}

/**
 * 运算符重载
 */
operator fun String.times(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}


val String.str: String
    get() = "str测试"