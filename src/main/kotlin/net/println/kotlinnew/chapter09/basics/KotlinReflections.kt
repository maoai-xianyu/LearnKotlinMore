package net.println.kotlinnew.chapter09.basics

import kotlin.reflect.KClass
import kotlin.reflect.full.declaredMemberProperties
import kotlin.reflect.typeOf

@ExperimentalStdlibApi
fun main() {
    var cls: KClass<String> = String::class

    val property = cls.declaredMemberProperties.firstOrNull()

    val mapCls = Map::class
    println(mapCls)
    val mapType = typeOf<Map<String, Int>>()
    // 获取泛型实参
    mapType.arguments.forEach {
        println(it)
    }
}

object B {
    fun hello(){

    }
}

class A {
    // 有两个receiver
    fun String.hello(){
    }
}

open class Super<T>

class Sub: Super<String>()