package net.println.kotlinnew.chapter01or02

/**
 *
 * @author zhangkun
 * @time 2020/8/10 8:31 上午
 */
fun main(args: Array<String>) {


    testReturn()

    val bFlag = true

    if (bFlag) {
        println("coding 1")
        return
    }

    println("coding 2")
}

fun testReturn() {
    val bFlag = true

    if (bFlag) {
        println("coding 0")
        return
    }
}