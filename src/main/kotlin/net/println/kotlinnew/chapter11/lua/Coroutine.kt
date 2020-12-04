package net.println.kotlinnew.chapter11.lua

import java.util.concurrent.atomic.AtomicReference
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.createCoroutine

/*
sealed class Status {
    // 创建
    class Created(val continuation: Continuation<Unit>) : Status()

    // 挂起了之后,需要 Resumed 返回的值 R 作为参数 P
    class Yielded<P>(val continuation: Continuation<P>) : Status()

    // 恢复挂起，需要返回值 R
    class Resumed<R>(val continuation: Continuation<R>) : Status()

    object Dead : Status()

}

// P 需要的参数，R 返回的参数
class Coroutine<P, R>(
    override val context: CoroutineContext = EmptyCoroutineContext,
    // 需要调用方法中的yield,需要使用带接受对象的函数
    private val block: suspend Coroutine<P, R>.CoroutineBody.(P) -> R
) : Continuation<R> {

    // 这里希望 yield 在 Coroutine 的内部使用
    // CoroutineBody 外部拿不到
    inner class CoroutineBody : Continuation<Any> {
        var parameter: P? = null
        suspend fun yield(value: R): P {

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
        val start = coroutineBlock.createCoroutine(body, this)
        status = AtomicReference(Status.Created(start))
    }
    // 协程执行完之后调用
    override fun resumeWith(result: Result<R>) {
        // 状态的扭转
        val previousStatus = status.getAndUpdate {  }

    }


}*/
