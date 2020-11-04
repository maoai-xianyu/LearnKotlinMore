package net.println.kotlinnew.chapter09.genericparams

import net.println.kotlinnew.chapter09.eg.UserDTO
import java.lang.reflect.ParameterizedType
import kotlin.reflect.full.declaredFunctions

/**
 * 获取泛型实参
 */

interface Api {
    fun getUsers(): List<UserDTO>
}

abstract class SuperType<T> {
    val typeParameter by lazy {
        // this 一定是子类的class  获取  SubType 的 第一个继承的类 SuperType
        this::class.supertypes.first().arguments.first().type!!
    }

    val typeParameterJava by lazy {
        this.javaClass.genericSuperclass.safeAs<ParameterizedType>()!!.actualTypeArguments.first()
    }
}

open class SubType : SuperType<String>()

//  使用 SubType2 它的 first 是 SubType 不是 SuperType，所以需要具体问题具体对待
class SubType2 :SubType()

fun main() {
    //Api::class.declaredFunctions.filter { it.name == "getUsers" }.first()
    Api::class.declaredFunctions.first { it.name == "getUsers" }
        .returnType.arguments.forEach {
        println(it)
    }

    println("--------")
    // 获取方法的返回类型returnType 再获取返回类型的参数 arguments
    Api::getUsers.returnType.arguments.forEach {
        println(it)
    }

    // Api::class.java.getDeclaredMethod("getUsers").genericReturnType 返回的是Type 强转为 ParameterizedType
    (Api::class.java.getDeclaredMethod("getUsers")
        .genericReturnType as ParameterizedType).actualTypeArguments.forEach {
        println(it)
    }
    println("----------下面是安全的转换")

    Api::class.java.getDeclaredMethod("getUsers")
        .genericReturnType.safeAs<ParameterizedType>()?.actualTypeArguments?.forEach {
        println(it)
    }

    val subType = SubType()
    subType.typeParameter.let(::println)
    subType.typeParameterJava.let(::println)
}

// 安全的转换
fun <T> Any.safeAs(): T? {
    return this as? T
}