package net.println.kotlinnew.chapter05

/**
 *
 * @author zhangkun
 * @time 2020/6/10 10:59 下午
 */

fun main(args: Array<String>) {

    val test = { p: Int -> p + 1 }
    val intArray = IntArray(5, test)
    println(intArray.joinToString())

    //region +折叠
    val intAr = IntArray(5) { it + 1 }
    println(intAr.joinToString())
    //endregion
}

