package net.println.kotlin.chapter05

/**
 *
 * @author zhangkun
 * @time 2020/6/2 11:29 上午
 * 闭包
 */

val string = "helloworld"

fun makeFun(): () -> Unit {
    var count = 0
    return fun() {
        println(++count)
    }
}

// 斐波那契数列
fun fibonacc(): () -> Long {
    var first = 0L
    var second = 1L
    return fun(): Long {
        val result = second
        second += first
        first = second - first
        return result
    }
}

fun fibonacc1(): Iterable<Long> {
    var first = 0L
    var second = 1L
    return Iterable {
        object : LongIterator() {
            override fun hasNext() = true

            override fun nextLong(): Long {
                val result = second
                second += first
                first = second - first
                return result
            }
        }
    }
}

fun main(args: Array<String>) {
    val method = makeFun()
    method()
    method()
    method()
    method()

    val sum22 = sum22(1, 2)
    println("sum22 $sum22")

    val fibonacc = fibonacc()
    println("------fibonacc-start--")
    println(fibonacc())
    println(fibonacc())
    println(fibonacc())
    println(fibonacc())
    println(fibonacc())
    println(fibonacc())
    println("------fibonacc- end --")

    println("---------------")
    for (i in fibonacc1()) {
        if (i > 100) break
        println(i)
    }

    println("---add == add1-----")
    val add5 = add(5)
    println(add5(2))

}


fun add(x: Int): (Int) -> Int {
    return fun(y: Int): Int {
        return x + y
    }
}

fun add1(x: Int) = fun(y: Int) = x + y

fun sum22(numb1: Int, numb2: Int, flag: Boolean = false) = if (flag) numb1 + numb2 else 0
