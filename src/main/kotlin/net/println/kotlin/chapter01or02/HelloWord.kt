package net.println.kotlin.chapter01or02

/**
 *
 * @author zhangkun
 * @time 2020/2/24 3:00 下午
 */


const val FINAL_H: String = "helloworld"
val FINAL_HS: String = "helloworld"
var FINAL_HHH: String = "helloworld"

fun main(args: Array<String>) {


    println("hello world!")
    val arr = intArrayOf(0, 1, 2,3, 4, 5, 6, 7, 8)
    arr.forEach(::println)

    println("-----")

    arr.forEach forEach@{
        if (it == 2) return@forEach
        println(it)
    }
}