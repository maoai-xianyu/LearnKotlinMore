package net.println.kotlinnew.chapter08.basics

/**
 *
 * @author zhangkun
 * @time 2020/10/21 11:50 上午
 */

sealed class IntList<out T> {
    object Nil : IntList<Nothing>() {
        override fun toString(): String {
            return "Nil"
        }
    }

    data class Cons<E>(val head: E, val tail: IntList<E>) : IntList<E>() {
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

fun <T> intListOf(vararg ints: Int): IntList<T> {
    return when (ints.size) {
        0 -> IntList.Nil
        else -> {
            val cons = IntList.Cons(
                ints[0],
                // * 将数组拆分为可变参数vararg
                intListOf(
                    *(ints.slice(1 until ints.size).toIntArray())
                )
            )
            cons as IntList<T>
        }
    }
}

// [0,1,2,3]
fun main() {
    val list = IntList.Cons<Int>(
        0,
        IntList.Cons(
            1,
            IntList.Cons(
                2,
                IntList.Cons(
                    3,
                    IntList.Nil
                )
            )
        )
    )
    println(list)

    val listResult = intListOf<Int>(0, 1, 2, 3)
    println(listResult)
    println(listResult.joinToString("-"))
}