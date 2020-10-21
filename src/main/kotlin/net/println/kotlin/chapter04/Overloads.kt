package net.println.kotlin.chapter04

/**
 *
 * @author zhangkun
 * @time 2020/5/27 9:04 上午
 */

class Overloads {

    // 方法的重载
    fun a(): Int {
        return 0
    }

    fun a(a: Int): Int {
        return a
    }

    fun a(string: String): Int {
        return string.length
    }

    // 默认参数
    fun b(b: Int = 0): Int {
        return b
    }

    @JvmOverloads
    fun c(b: Int = 0): Int {
        return b
    }
}

fun main(args: Array<String>) {
    val overloads = Overloads()
    overloads.b()
    val arrayList = arrayListOf<Int>()

    arrayList.add(2)
    arrayList.add(6)
    arrayList.add(4)
    arrayList.add(5)
    arrayList.add(7)
    arrayList.add(9)
    arrayList.add(12)
    // 移除第一个
    arrayList.removeAt(1)
    // 移除值为4的一项
    arrayList.remove(4)

    println(arrayList)
}