package net.println.kotlin.chapter08.kotlinreflections

/**
 *
 * @author zhangkun
 * @time 2020/10/21 8:13 下午
 */

fun main(args: Array<String>) {

    String::class.members.forEach{
        println(it)
    }
}