package net.println.kotlinnew.chapter11.python

import kotlin.coroutines.*

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
        return GeneratorIterator(block, parameter)
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

    // 没有切换线程，线程不安全
    private var state: State

    // 启动协程
    init {
        // 将有参数输入的 suspend GeneratorScope<T>.(T) -> Unit 转换为 没有参数的  GeneratorScope<T>.() -> Unit
        val coroutineBlock: suspend GeneratorScope<T>.() -> Unit = { block(parameter) }
        // 启动协程，创建了协程，不需要立即启动。需要别人先来调用我，resume。第二个参数标记协程是否执行完
        val start = coroutineBlock.createCoroutine(this, this)
        state = State.NotReady(start)
    }


    override suspend fun yield(value: T) = suspendCoroutine<Unit> { continuation ->
        println("yield 前  $state")
        state = when (state) {
            // 挂起
            is State.NotReady -> State.Ready(continuation, value)
            is State.Ready<*> -> throw IllegalAccessException("cannot yield a value while ready")
            State.Done -> throw IllegalAccessException("cannot yield a value while done")
        }
        println("yield 后  $state")
    }

    private fun resume() {
        println("resume  $state")
        when (val currentState = state) {
            // 调用挂起函数
            is State.NotReady -> {
                println("启动 协程")
                currentState.continuation.resume(Unit);
            }
        }
    }

    override fun hasNext(): Boolean {
        println("hasNext resume 前 $state")
        resume()
        println("hasNext resume 后 $state")
        return state != State.Done
    }

    // 返回下一次yield 需要参数 value
    override fun next(): T {
        return when (val currentState = state) {
            is State.NotReady -> {
                println("next notReady 前 $state")
                resume()
                println("next notReady 后 $state")
                return next()
            }
            is State.Ready<*> -> {
                println("next Ready 前 $state")
                // 状态扭转
                state = State.NotReady(currentState.continuation)
                println("next Ready 后  $state")
                (currentState as State.Ready<T>).nextValue

            }
            State.Done -> throw IndexOutOfBoundsException("No value left.")
        }
    }


    override fun resumeWith(result: Result<Any?>) {
        println("")
        println("resumeWith 前 $state")
        // 状态扭转
        state = State.Done
        println("resumeWith 后 $state")
        result.getOrThrow()
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
        for (i in 0..2) {
            println("yield")
            yield(start + i)
        }
    }

    val seq = nums(10)

    for (j in seq) {
        println(j)
    }

    // 协程提供的方法
    val sequ = sequence {

        yield(1)
        yield(2)
        yield(3)
        yield(4)
        yieldAll(listOf(1,2,3,4))
    }

    for(i in sequ) {
        println("i  $i")
    }

}