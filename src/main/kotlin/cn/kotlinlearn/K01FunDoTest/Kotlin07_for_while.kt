package cn.kotlinlearn.K01FunDoTest

/**
 * author:  zhangkun .
 * date:    on 2017/9/13.
 */
fun main(args: Array<String>) {
    forFun()
}


//------------- for
fun forFun() {

    val arrayInt = intArrayOf(1, 2, 3, 4, 5)
    for (item in arrayInt) {
        println(" $item")
        println(" 测试  " + item)
    }

    arrayInt.forEach { println("  HAH  " + it) }

    val iterator = arrayInt.iterator()

    iterator.forEach { print("iterator" + it) }

    // 遍历数组角标
    for (item in arrayInt.indices) {
        println(" arrayInt[$item]  is " + arrayInt[item])
        println(" arrayInt[$item]  is ${arrayInt[item]}")
    }

    // withIndex
    for ((index, value) in arrayInt.withIndex()) {

        println(" arrayInt[$index]  is $value")
    }

    //区间 是 Kotlin 加入的一种新的数据形式，它的构成是 较小元素 .. 较大元素，这里的“..”操作符重载了 rangeTo() 函数

    // 整数区间，而且只有整数区间才能用作 for 循环中的迭代：

    for (i in 1..5) print(" " + i) //输出 1 到 5 的数字

    println()
    for (i in 5 downTo 1) print(" " + i) //输出 5 到 1 的数字
    println()

    for (i in 5 downTo 1 step 3) print("" + i) //输出 5 2
    println()

    for (i in 1..5 step 2) print(" " + i) //输出 1 3 5

}


// while 语句和java 完全相同