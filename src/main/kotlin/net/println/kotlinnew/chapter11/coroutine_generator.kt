package net.println.kotlinnew.chapter11

import java.lang.reflect.Parameter

/**
 *
 * @author zhangkun
 * @time 2020/11/25 8:58 上午
 */

interface Generator<T> {
    operator fun iterator(): Iterator<T>
}

class GeneratorImpl<T>(private val block: suspend GeneratorScope<T>.(T) -> Unit, private val parameter: T) :
    Generator<T> {
    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }
}

abstract class GeneratorScope<T> internal constructor() {
    protected abstract val parameter: T
    abstract suspend fun yield(value: T)
}

fun <T> generator(block: suspend GeneratorScope<T>.(T) -> Unit): (T) -> Generator<T> {
    return { parameter: T ->
        GeneratorImpl(block, parameter)
    }
}

fun main() {
    val nums = generator { start: Int ->
        for (i in 0..5) {
            yield(start + 1)
        }
    }

    val seq = nums(10)

    for (j in seq) {
        println(j)
    }

}