package cn.edwardLearn

import java.math.BigDecimal

/**
 * author:  zhangkun .
 * date:    on 2018/5/29.
 */
fun main(args: Array<String>) {


    val names = arrayOf("JSON", "BING", "PANG", "tom")

    val longArray1 = arrayOf(1L, 2L, 4L)
    val longArray2: Array<Long> = arrayOf(1, 2, 4)
    val longArray3 = arrayOf<Long>(1, 2, 4)
    val longArray4 = arrayOf(1, 2, 4)

    println(longArray4 is Array<Int>)
    println(longArray4[1])
    longArray4[2] = 10
    println(longArray4[2])

    println("-------------------------------------")
    val evenNumber = Array(5) { i -> i * 2 }

    for (num in evenNumber) println(num)

    println("-------------------------------------")

    var oneArray: Array<Int> = arrayOf(1, 2, 3, 4)
    oneArray = Array(3) { i -> i * 30 }

    for (num in oneArray) println(num)
    println("-------------------------------------")
    val mixeArray = arrayOf("hello", 1, 2, 3, 4, BigDecimal(10.02), 'v')

    for (num in mixeArray) println(num)

    println("-------------------------------------")

    val myIntArray = arrayOf(2, 5, 6, 300)
    val stu = Stu("jack", 12)
    stu.printNumbers(myIntArray.toIntArray())

    // 或者 转换方式
    val myIntArray1 = intArrayOf(2, 5, 6, 300)
    stu.printNumbers(myIntArray1)

    println("-------------------------------------")
    val toTypedArray = myIntArray1.toTypedArray()
    for (num in toTypedArray) println(num)
    println("-------------------------------------")

    val nullArray = arrayOfNulls<Int>(5)
    nullArray[2] = 200
    for (num in nullArray) println(num)
    println("-------------------------------------")
    val printArray = IntArray(5)
    printArray[2] = 2
    for (num in printArray) println(num)
}

