package net.println.kotlinnew.chapter11.common

import kotlinx.coroutines.delay
import net.println.kotlinnew.chapter11.utils.Logger
import net.println.kotlinnew.chapter11.utils.log
import kotlin.coroutines.Continuation
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext
import kotlin.coroutines.startCoroutine

/**
 *
 * @author zhangkun
 * @time 2020/12/13 8:29 下午
 */

suspend fun main() {

    Logger.debug(1)
    Logger.debug(returnSuspend())
    Logger.debug(2)
    delay(1000)
    Logger.debug(3)
    Logger.debug(returnImmediately())
    Logger.debug(4)
}

suspend fun returnImmediately() {
    suspend {
        foo()
    }.startCoroutine(object : Continuation<Unit> {
        override val context: CoroutineContext = EmptyCoroutineContext

        override fun resumeWith(result: Result<Unit>) {
            Logger.debug("returnImmediately  result $result")
        }
    })
}

suspend fun returnSuspend() {
    suspend {
        suspend()
    }.startCoroutine(object : Continuation<Unit> {
        override val context: CoroutineContext = EmptyCoroutineContext

        override fun resumeWith(result: Result<Unit>) {
            Logger.debug("returnSuspend result $result")
            Logger.debug("returnSuspend result ${result.isSuccess}")
            Logger.debug("returnSuspend result ${result.exceptionOrNull()}")
        }
    })
}
