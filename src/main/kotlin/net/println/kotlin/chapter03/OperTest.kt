package net.println.kotlin.chapter03

/**
 *
 * @author zhangkun
 * @time 2020/4/9 11:12 下午
 */

class Complex(var real: Double, var imaginary: Double) {
    // operator 操作符运算
    operator fun plus(other: Complex): Complex {
        return Complex(real + other.real, imaginary + other.imaginary)
    }

    operator fun plus(other: Int): Complex {
        return Complex(real + other, imaginary)
    }

    operator fun invoke(): Double {
        return Math.hypot(real, imaginary)
    }

    override fun toString(): String {
        return "$real + ${imaginary}i"
    }
}

class Book {
    // 中缀表达式  infix
    infix fun on(any: Any): Boolean {
        return false
    }
}

class Desk

fun main(vararg args: String) {
    val a = Complex(3.0, 4.0)// 3+4i
    val b = Complex(2.0, 7.5)// 2+7.5i
    println(a + b)
    println(a + 5)
    println(a())
    println(a.invoke())

    if (Book() on Desk()) { // DSL语法
    }

    val ifTest = "Test"

    val myTest = if (ifTest == "Test") {
        "测试"
    } else {
        "非测试"
    }

    hello(1, 2, 3, 4, 5, 6, str = "hello")

    val intsA = intArrayOf(1, 2, 3, 4, 5)
    hello(*intsA, str = "hello")

    val intsList = arrayListOf<Int>(1, 2, 3, 4, 5)
    // 不支持list
    //hello(*intsList, str = "hello")

    helloDefault(ints = *intsA, str = "hello")

}


fun hello(vararg ints: Int, str: String) {
    ints.forEach(::println)
    println(str)
}


fun helloDefault(double: Double = 3.0, vararg ints: Int, str: String) {
    ints.forEach(::println)
    println(str)
}
