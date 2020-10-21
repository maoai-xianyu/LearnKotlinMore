package cn.kotlinlearn.K09HighFunction

import java.io.File

/**
 * author:  zhangkun .
 * date:    on 2018/5/25.
 * count() 一是无参的形式，它返回总数，一般直接通过调用 size 属性实现；二是接受一个 Boolean 函数作为参数的形式，它 返回符合条件的元素数目
 *
 * joinTo() 与 joinToString()  joinToString() 函数是对 joinTo() 函数的封装，可以方便地联结字符串
 *
 */
fun main(args: Array<String>) {
    val a = 20

    println(" 20 的 结果是  = "+a.countOfBinaryOnes())

}

fun Int.countOfBinaryOnes() = (0..21).count { (this shr it) and 1 == 1 }


fun File.listFilesReadable(): String {
    return if (isDirectory)
        listFiles().joinToString("\n") { it.name }
    else name
}