package net.println.kotlin.chapter04

/**
 *
 * @author zhangkun
 * @time 2020/5/14 7:10 下午
 *
 * 多个接口方法冲突，可以使用 super进行区分调用的方法
 */

interface B {
    fun x(): Int = 1
}

interface C {
    fun x(): Int = 0
}

abstract class Y {
    open fun x(): Int = 5
}

class M(var y: Int = 0) : Y(), B, C {
    override fun x(): Int {
        println("call x(): Int in D")
        if (y > 0) {
            return y
        } else if (y < -200) {
            return super<C>.x()
        } else if (y < -100) {
            return super<B>.x()
        } else {
            return super<Y>.x()
        }
    }
}

fun main(args: Array<String>) {
    println(M(3).x())
    println(M(-10).x())
    println(M(-110).x())
    println(M(-1100).x())
}