package net.println.kotlinnew.chapter11.common

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.println.kotlinnew.chapter11.utils.log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.lang.Exception
import kotlin.coroutines.*

/**
 *
 * @author zhangkun
 * @time 2020/12/9 9:03 上午
 */
fun async() {
    val call = getGitHubApi.getUserCallback("bennyhuo")
    call.enqueue(object : Callback<User> {
        override fun onFailure(p0: Call<User>, t: Throwable) {
            showError(t)
        }

        override fun onResponse(p0: Call<User>, response: Response<User>) {
            response.body()?.let(::showUser) ?: showError(NullPointerException())
        }
    })
}

fun asyncLoop() {
    val names = arrayOf("abreslav", "udalov", "maoai-xianyu")
    names.forEach {
        val call = getGitHubApi.getUserCallback(it)

        call.enqueue(object : Callback<User> {
            override fun onFailure(p0: Call<User>, t: Throwable) {
                showError(t)
            }

            override fun onResponse(p0: Call<User>, response: Response<User>) {
                response.body()?.let(::showUser) ?: showError(NullPointerException())
            }
        })
    }
}

suspend fun suspend() {
    try {
        val userSuspend = getGitHubApi.getUserSuspend("maoai-xianyu")
        showUser(userSuspend)
    } catch (e: Exception) {
        showError(e)
    }
}

suspend fun suspendLoop() {
    val names = arrayOf("abreslav", "udalov", "maoai-xianyu")
   names.forEach {
       try {
           val userSuspend = getGitHubApi.getUserSuspend(it)
           showUser(userSuspend)
       } catch (e: Exception) {
           showError(e)
       }
   }
}

suspend fun suspendLoopMap() {
    val names = arrayOf("abreslav", "udalov", "maoai-xianyu")
    val list = names.map {
        getGitHubApi.getUserSuspend(it)
    }
    list.forEach {
        println(it)
    }
}



suspend fun getUserSuspend(name:String) = suspendCoroutine<User> {
    continuation ->
    getGitHubApi.getUserCallback(name).enqueue(object :Callback<User>{
        override fun onFailure(call: Call<User>, t: Throwable) {
            continuation.resumeWithException(t)
        }

        override fun onResponse(call: Call<User>, response: Response<User>) {
            println(" suspendCoroutine success")
            response.takeIf { it.isSuccessful }?.body()?.let(continuation::resume)
                ?: continuation.resumeWithException(NullPointerException())
        }
    })
}


suspend fun main() {
    //async()
    println("-----")
    //asyncLoop()
    println("-----suspend")

    /*GlobalScope.launch {
        suspend()
    }.join()*/

    println("startCoroutine")
    suspend {
        suspend()
    }.startCoroutine(object : Continuation<Unit> {
        override val context: CoroutineContext = EmptyCoroutineContext
        override fun resumeWith(result: Result<Unit>) {
            log("startCoroutine  $result")
        }
    })

    println("createCoroutine")
    suspend {
        suspendLoop()
    }.createCoroutine(object : Continuation<Unit> {
        override val context: CoroutineContext = EmptyCoroutineContext
        override fun resumeWith(result: Result<Unit>) {
            log("createCoroutine  $result")
        }
    }).resume(Unit)

    getUserSuspend("maoai-xianyu")

}