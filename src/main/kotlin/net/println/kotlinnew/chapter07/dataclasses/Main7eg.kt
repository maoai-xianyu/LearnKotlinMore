package net.println.kotlinnew.chapter07.dataclasses

import com.google.gson.Gson

/**
 *
 * @author zhangkun
 * @time 2020/6/11 11:39 下午
 */

data class Person7(val name:String,val age:Int)
fun main(args: Array<String>) {
    gsonfun()
}

fun gsonfun(){
    val gson = Gson()
    println(gson.toJson(Person7("zk", 20)))
    println(gson.fromJson("""{"name":"dddd","age":20}""", Person7::class.java))
}