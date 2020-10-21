package cn.edwardLearn

import java.math.BigDecimal

// Kotlin  Generics  Functions  泛型

fun main(args: Array<String>) {

    val nameList: MutableList<String> = mutableListOf()
    val stringList: List<String> = listOf("hello", "Good-Bye")
    val bdList: List<BigDecimal> = listOf(BigDecimal(8.5), BigDecimal(4.2), BigDecimal(12.8))



    printList(stringList)
    printList(bdList)

    println("---------------- 扩展")

    stringList.printLists()

    bdList.printLists()


    val ints: List<Int?> = listOf(1, 2, 3, 4, 5)
    ints.printLists()

    println("---------------- 转")

    bdList.convertToInt()

    val floats: List<Float> = listOf(100.2f, 90.2f)
    floats.convertToInt()

    println("---------------- 转")

    StringBuilder("string1").appendString(StringBuilder("String2"))
}

// Generics  函数有一个 T的情况

fun <T> printList(list: List<T>) {

    list.forEach { println(it) }
}

// 扩展函数
fun <T> List<T>.printLists() {
    forEach { println(it) }
}

fun <T : Number> List<T>.convertToInt() {
    forEach { println("${it.toInt()}") }
}

// Generics  函数有两个或者两个以上 T的情况，用where

fun <T> T.appendString(param: T)
        where T : CharSequence, T : Appendable {
    println("Result is ${append(param)}")
}