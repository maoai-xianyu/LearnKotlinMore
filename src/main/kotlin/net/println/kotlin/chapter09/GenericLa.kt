package net.println.kotlin.chapter09

/**
 *
 * @author zhangkun
 * @time 2020/10/16 3:40 下午
 */

fun main() {
    val a = 3
    val b = 10
    val result = maxOf(a, b)
    println(result)

    val aC = Complex(2.0, 3.0)
    val aD = Complex(3.0, 4.0)
    val cR = maxOf(aC,aD)
    println(cR)


    val cl1 = Complex1(2.0, 3.0)
    val cl2 = Complex1(2, 3)
    println(cl1)
}

data class Complex(var real: Double, var imaginary: Double) : Comparable<Complex> {

    override fun compareTo(other: Complex): Int {
        return (value() - other.value()).toInt()
    }

    fun value(): Double {
        return real * real + imaginary * imaginary
    }

    override fun toString(): String {
        return ("$real +$imaginary i ")
    }
}

// 为类声明泛型
data class Complex1<T:Number>(var real: T, var imaginary: T){
    override fun toString(): String {
        return ("$real +$imaginary i ")
    }
}

// > 需要继承 Comparable 为方法声明泛型
fun <T : Comparable<T>> maxOf(a: T, b: T): T {
    return if (a > b) a else b
}