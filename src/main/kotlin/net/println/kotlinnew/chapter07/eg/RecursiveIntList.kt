package net.println.kotlinnew.chapter07.eg

/**
 *
 * @author zhangkun
 * @time 2020/10/21 11:50 上午
 */

sealed class IntList {
    object Nil : IntList() {
        override fun toString(): String {
            return "Nil"
        }
    }

    data class Cons(val head: Int, val tail: IntList) : IntList() {
        override fun toString(): String {
            return "$head $tail"
        }
    }

    fun joinToString(sep: String = ","): String {
        return when (this) {
            Nil -> "Nil"
            is Cons -> {
                "${head}$sep${tail.joinToString(sep)}"
            }
        }
    }
}

// 可以解构的不一定是数据类，IntList 不能解构，
// 如果想要解构，需要重写 component(运算符) 方法
operator fun IntList.component1(): Int? {
    return when(this){
        IntList.Nil -> null
        is IntList.Cons -> head
    }
}

operator fun IntList.component2(): Int? {
    return when(this){
        IntList.Nil -> null
        is IntList.Cons -> tail.component1()
    }
}
operator fun IntList.component3(): Int? {
    return when(this){
        IntList.Nil -> null
        is IntList.Cons -> tail.component2()
    }
}

fun IntList.sum(): Int {
    return when (this) {
        IntList.Nil -> {
            println(" Nil")
            0
        }
        is IntList.Cons -> {
            println("head $head")
            val i = head + tail.sum()
            println("head --  $i")
            i
        }
    }
}


fun intListOf(vararg ints: Int): IntList {
    return when (ints.size) {
        0 -> IntList.Nil
        else -> {
            val cons = IntList.Cons(
                ints[0],
                // * 将数组拆分为可变参数vararg
                intListOf(*(ints.slice(1 until ints.size).toIntArray()))
            )
            cons
        }
    }
}

// [0,1,2,3]
fun main() {
    val list = IntList.Cons(0, IntList.Cons(1, IntList.Cons(2, IntList.Cons(3, IntList.Nil))))
    println(list)

    val listResult = intListOf(0, 1, 2, 3)
    println(listResult)
    println(listResult.joinToString("-"))
    println(listResult.sum())

    val (x,y,z) = listResult
    println(" x $x  y $y  z $z")

    // list 定义了5个 component
    val (a,b,c,d,e) = listOf<Int>()
}