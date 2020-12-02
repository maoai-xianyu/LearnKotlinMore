package net.println.kotlinnew.chapter11.python

import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine

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

// 有值状态的类，用在value上
sealed class State {

    // 没有准备好，需要一个协程体继续执行
    class NotReady(val continuation: Continuation<Unit>) : State()

    // 准备好，有值了，就是执行yeild之后
    class Ready<T>(val continuation: Continuation<Unit>, val nextValue: T) : State()

    object Done : State()

}

class GeneratorIterator<T>(private val block: suspend GeneratorScope<T>.(T) -> Unit, override val parameter: T) :
    GeneratorScope<T>(), Iterator<T>, Continuation<Any?> {
    override val context: CoroutineContext = EmptyCoroutineContext

    private var state: State

    // 启动协程
    init {
        // 将有参数输入的 suspend GeneratorScope<T>.(T) -> Unit 转换为 没有参数的  GeneratorScope<T>.() -> Unit
        val coroutineBlock: suspend GeneratorScope<T>.() -> Unit = { block(parameter) }
        val start = coroutineBlock.createCoroutine(this, this)
        state = State.NotReady(start)

    }


    override suspend fun yield(value: T) {
        TODO("Not yet implemented")
    }

    override fun hasNext(): Boolean {
        TODO("Not yet implemented")
    }

    // 返回下一次yield 需要参数 value
    override fun next(): T {
        TODO("Not yet implemented")
    }


    override fun resumeWith(result: Result<Any?>) {
        TODO("Not yet implemented")
    }
}

// 不需要外部调用
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