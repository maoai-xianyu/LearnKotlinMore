package net.println.kotlin.chapter05

import java.io.OutputStream
import java.nio.charset.Charset

/**
 *
 * @author zhangkun
 * @time 2020/6/2 12:21 下午
 *  柯里化 函数调用链
 */
fun log(tag: String, target: OutputStream, message: Any?) {
    target.write("[$tag] $message\n".toByteArray())
}

// 柯里化
fun logk(tag: String) = fun(target: OutputStream) = fun(message: Any?) = target.write("[$tag] $message\n".toByteArray())

fun main(args: Array<String>) {
    log("coding", System.out, "test")
    logk("coding")(System.out)("test2")
    ::log.curried()("coding")(System.out)("扩展 test2")


    val consoleLogWithTag = ::log.curried()("coding")(System.out)
    consoleLogWithTag("偏函数 test2")
    consoleLogWithTag("偏函数 test2")
    consoleLogWithTag("偏函数 test2")

    val bytes = "我是中国人".toByteArray(charset("GBK"))
    val makeStringFromGbkBytes1 = makeStringFromGbkBytes(bytes)
    println(makeStringFromGbkBytes1)
}

fun <P1, P2, P3, R> Function3<P1, P2, P3, R>.curried() = fun(p1: P1) = fun(p2: P2) = fun(p3: P3) = this(p1, p2, p3)

val makeString = fun(byteArray: ByteArray, charset: Charset): String {
    return String(byteArray, charset)
}

val makeStringFromGbkBytes = makeString.partial2(charset("GBK"))

fun <P1, P2, R> Function2<P1, P2, R>.partial2(p2: P2) = fun(p1: P1) = this(p1, p2)
fun <P1, P2, R> Function2<P1, P2, R>.partial1(p1: P1) = fun(p2: P2) = this(p1, p2)

