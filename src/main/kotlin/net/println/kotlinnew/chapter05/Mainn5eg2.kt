package net.println.kotlinnew.chapter05

/**
 *
 * @author zhangkun
 * @time 2020/6/10 11:14 下午
 */

operator fun String.minus(right: Any?): String = this.replaceFirst(right.toString(), "")

operator fun String.times(right: Int): String {
    return (1..right).joinToString("") { this }
}

/*operator fun String.times(int: Int): String {
    val stringBuilder = StringBuilder()
    for (i in 0 until int) {
        stringBuilder.append(this)
    }
    return stringBuilder.toString()
}*/

operator fun String.div(right: Any?): Int {
    val right = right.toString()
    // 窗上滑动
    return this.windowed(right.length, 1, transform = {
        it == right
    }).count { it }
    // 最后一个是lambda表达式，可以移到外面
    /* return this.windowed(right.length, 1) {
         it == right
     }.count { it }*/
}

fun main(args: Array<String>) {
    val value1 = "HelloWorld"
    println(value1 - "World")
    val value2 = "HelloWorld"
    println(value2 * 2)
    val value3 = "HelloWorld"
    println(value3 / 3)
    val value4 = "HelloWorld HelloWorld"
    println(value4 / "l")
    println(value4 / "ld")
}



