package com.mao.cn.kotlinlearn.K07Collection.mapListSet

/**
 * Created by Ming on 2017/9/12.
 */
fun main(args: Array<String>) {
    
    val user = User(0, "Hello")
    println(user)

    HelloKotlin::class.constructors.map { println(it) }

}

class HelloKotlin{
    fun hello(){

    }
}