package net.println.kotlinnew.chapter10.eg.gson

import com.google.gson.Gson
import net.println.kotlin.chapter09.fromJson


fun main() {
    val user = Gson().fromJson<UserVO>(UserVO.CACHE_RESPONSE)
    println(user)


    val user1 = Gson().fromJson<UserVO>(UserVO.CACHE_RESPONSE_2)
    println(user1)
}