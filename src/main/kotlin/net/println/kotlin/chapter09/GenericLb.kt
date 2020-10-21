package net.println.kotlin.chapter09

import com.google.gson.Gson
import java.io.File

/**
 *
 * @author zhangkun
 * @time 2020/10/16 3:40 下午
 */

fun main() {
    testGenericss<String>()
    // 等同于
    println(String::class.java)

    val person = PersonJson("benny", 18)
    // 写入文件
    Gson().toJson(person).let {
        File("personJson.json").writeText(it)
    }
    // 读json
    Gson().fromJson<PersonJson>(File("personJson.json").readText()).let {
        println("${it.name}  --${it.age}")
    }
    println("-----")
    needAdPersonJson(  Gson().fromJson(File("personJson.json").readText()))
}

fun needAdPersonJson(personJson: PersonJson){
    println("${personJson.name}  --${personJson.age}")
}

fun <T> testGenerics() {
    println()
}

// inline 把这段代码植入到调用点处  reified 让 T 具体化
inline fun <reified T> testGenericss() {
    println(T::class.java)
}

data class PersonJson(val name: String, val age: Int)

inline fun <reified T> Gson.fromJson(json: String): T =
    fromJson(json, T::class.java)