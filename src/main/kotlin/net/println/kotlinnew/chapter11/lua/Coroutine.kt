package net.println.kotlinnew.chapter11.lua

import net.println.kotlinnew.chapter11.utils.Logger
import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.*


sealed class Status {
    // 创建
    class Created(val continuation: Continuation<Unit>) : Status()

    // 挂起了之后,需要 Resumed 返回的值 R 作为参数 P，
    // Yielded之后，待会Resume的时候，需要传入参数。参数传进来的时候需要调用Yielded保留的continuation
    class Yielded<P>(val continuation: Continuation<P>) : Status()

    // 恢复挂起，需要返回值 R
    class Resumed<R>(val continuation: Continuation<R>) : Status()

    object Dead : Status()

}

// P 需要的参数 也就是Resumed返回的值，R 返回值 也就是 Yielded 传出去的执行
// Coroutine 就是返回
class Coroutine<P, R>(
    override val context: CoroutineContext = EmptyCoroutineContext,
    // 需要调用方法中的yield,需要使用带接受对象的函数
    private val block: suspend Coroutine<P, R>.CoroutineBody.(P) -> R
) : Continuation<R> {

    companion object {
        fun <P, R> create(
            context: CoroutineContext = EmptyCoroutineContext,
            // 需要调用方法中的yield,需要使用带接受对象的函数
            block: suspend Coroutine<P, R>.CoroutineBody.(P) -> R
        ): Coroutine<P, R> {
            return Coroutine(context, block)
        }
    }

    // 这里希望 yield 在 Coroutine 的内部使用
    // CoroutineBody 外部拿不到
    inner class CoroutineBody {
        var parameter: P? = null
        suspend fun yield(value: R): P = suspendCoroutine { continuation ->
            Logger.debug("yield  执行时 status $status")
            val previousStatus = status.getAndUpdate {
                when (it) {
                    is Status.Created -> throw IllegalAccessException("Never start Coroutine")
                    is Status.Yielded<*> -> throw IllegalAccessException("Already  yielded")
                    is Status.Resumed<*> -> {
                        Status.Yielded(continuation)
                    }
                    Status.Dead -> throw IllegalAccessException("Already dead")
                }
            }
            Logger.debug("yield  执行之后 status $status")
            Logger.debug(" yield  previousStatus $previousStatus")
            (previousStatus as? Status.Resumed<R>)?.continuation?.resume(value)
        }

    }

    private val body = CoroutineBody()

    private val status: AtomicReference<Status>

    val isActive: Boolean
        get() = status.get() != Status.Dead

    init {
        // 创建协程的时候，lambda 表达式是不能有参数的
        // 传入进来的block 是有个一个 P 的参数，所以使用下面这种方式处理
        // parameter 不能传入进来，是因为需要Resumed 进行赋值
        val coroutineBlock: suspend CoroutineBody.() -> R = {
            block(parameter!!)
        }
        // this 是当前的 Coroutine，也就是执行完 coroutineBlock 之后，回调 this 的 resumeWith
        val start = coroutineBlock.createCoroutine(body, this)
        status = AtomicReference(Status.Created(start))
    }

    // 协程执行完之后调用
    override fun resumeWith(result: Result<R>) {
        Logger.debug("resumeWith completion 协程执行完恢复之后调动 status $status")
        // 状态的扭转
        val previousStatus = status.getAndUpdate {
            when (it) {
                // 还没有启动
                is Status.Created -> throw IllegalAccessException("Never start Coroutine")
                // 挂起了但是没有继续就结束了
                is Status.Yielded<*> -> throw IllegalAccessException("Already  yielded")
                is Status.Resumed<*> -> {
                    Status.Dead
                }
                // 如果是单例模式，可以省略 is
                Status.Dead -> throw IllegalAccessException("Already dead")
            }
        }
        Logger.debug("resumeWith completion 协程执行完恢复之后调动 status $status")
        Logger.debug("resumeWith previousStatus $previousStatus")
        // 如果是 Resumed 需要将值传出去
        (previousStatus as? Status.Resumed<R>)?.continuation?.resumeWith(result)

    }

    suspend fun resume(value: P): R = suspendCoroutine { continuation ->
        Logger.debug("resume 执行时 status $status")
        // 状态的扭转
        val previousStatus = status.getAndUpdate {
            when (it) {
                is Status.Created -> {
                    body.parameter = value
                    // Resumed 执行 block
                    Status.Resumed(continuation)
                }
                is Status.Yielded<*> -> {
                    Status.Resumed(continuation)
                }
                is Status.Resumed<*> -> throw IllegalAccessException("Already  Resumed")
                Status.Dead -> throw IllegalAccessException("Already  dead")
            }
        }
        Logger.debug("resume 执行时后 status $status")
        Logger.debug("resume previousStatus $previousStatus")

        when (previousStatus) {
            is Status.Created -> {
                Logger.debug("协程刚刚创建，启动协程")
                previousStatus.continuation.resume(Unit)
            }
            is Status.Yielded<*> -> {
                Logger.debug("协程刚刚执行挂起点")
                (previousStatus as Status.Yielded<P>).continuation.resume(value)
            }

        }
    }
}


class Dispatcher : ContinuationInterceptor {
    override val key = ContinuationInterceptor

    override fun <T> interceptContinuation(continuation: Continuation<T>): Continuation<T> {
        TODO("Not yet implemented")
    }
}

class DispatcherContinuation<T>(val continuation: Continuation<T>) : Continuation<T> {
    override val context: CoroutineContext
        get() = TODO("Not yet implemented")

    override fun resumeWith(result: Result<T>) {
        TODO("Not yet implemented")
    }

}


suspend fun main() {
    Logger.debug("producer 创建")
    val producer = Coroutine.create<Unit, Int>() {
        for (i in 0..3) {
            Logger.debug("producer send  $i")
            yield(i)
        }
        200
    }

    Logger.debug("consumer 创建")
    val consumer = Coroutine.create<Int, Unit>() { param: Int ->
        Logger.debug("consumer start  $param")
        for (i in 0..3) {
            val value = yield(Unit)
            Logger.debug("consumer receive  $value")
        }
    }

    while (producer.isActive && consumer.isActive) {
        val result = producer.resume(Unit)
        consumer.resume(result)
    }
}
