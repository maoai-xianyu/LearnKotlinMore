package net.println.kotlinnew.chapter11.common

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

}

fun main() {
    async()
}