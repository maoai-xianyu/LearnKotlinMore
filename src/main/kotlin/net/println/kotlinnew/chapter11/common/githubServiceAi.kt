package net.println.kotlinnew.chapter11.common


import net.println.kotlinnew.chapter10.eg.RetroApi
import net.println.kotlinnew.chapter11.utils.log
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *
 * @author zhangkun
 * @time 2020/12/9 8:15 上午
 */


val getGitHubApi by lazy {
    val retrofit = Retrofit.Builder()
        .client(OkHttpClient.Builder()
            .addInterceptor {
                it.proceed(it.request()).apply {
                    log("request : ${code()}")
                }
            }
            .build())
        .baseUrl("https://api.github.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    retrofit.create(GitHubApi::class.java)
}

interface GitHubApi {

    @GET("users/{login}")
    fun getUserCallback(@Path("login") login: String): Call<User>

    @GET("users/{login}")
    suspend fun getUserSuspend(@Path("login") login: String): Call<User>

}

data class User(val id: String, val name: String, val url: String)