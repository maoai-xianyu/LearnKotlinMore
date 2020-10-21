/**
 * 修改jvm的名字
 */
@file:JvmName("StaticCar")

package cn.edwardLearn.kp54kotlin

import java.io.IOException

/**
 * create by zhangkun .
 * on 2018/10/30
 */
class CarTest(val model:String,color:String,val year:Int,var isAutomatic:Boolean){


    companion object {

        const val isConst = true

        val ishBrid = false

        @JvmStatic
        val ishBridJvm = false

        fun carComp() = println("this  is companion function")

        @JvmStatic
        fun carCompJvm() = println("this  is companion function jvm")



    }

    fun typeTry(type:String){
        println("this is a function $type")
    }
}

fun topLevel() = println("this is a top level function in Car Kotin")

// 扩展函数
fun String.print() = println(this)


fun main(args: Array<String>) {

    "Hello".print()
}

// 单例
object SingletonObj{
    fun doSomething() = println("this is singletom")

    @JvmStatic
    fun doSomethingJvm() = println("this is singletom")
}

//异常
@Throws(IOException::class)
fun throwIOException(){
    throw IOException("exception")
}

// 参数有初始值
@JvmOverloads
fun defaultParam(str:String,num:Int = 20){
    println("str = $str+ num = $num")
}