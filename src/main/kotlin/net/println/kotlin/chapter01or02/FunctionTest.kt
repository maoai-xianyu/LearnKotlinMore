package net.println.kotlin.chapter01or02

import kotlin.system.exitProcess

/**
 *
 * @author zhangkun
 * @time 2020/4/8 8:56 上午
 */

fun main(args: Array<String>): Unit { // ( Array<String>)->Unit
    val arg1 = 1;
    val arg2 = 2;
    val arglong: Long = arg1.toLong()
    println("$arg1 + $arg2 = ${sum(arg1, arg2)}")
    println(longInt(arg1))

    /*val argass = arrayOf(1, 2, 3)
    checkargs(argass)
    println("上面是return函数。继续执行")*/

    println(sum2(3, 4))
    println(sum2.invoke(3, 4))


    println(sum2) //Function2<java.lang.Integer, java.lang.Integer, java.lang.Integer>

    println(::printUsemsg is () -> Unit)
    //public interface Function0<out R> : Function<R> {
    //    /** Invokes the function. */
    //    public operator fun invoke(): R
    //}

    // kotlin 定义了有23种的函数，参数最多有22个

    val arr = intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
    arr.forEach({ it -> println(it) })
    arr.forEach() { println(it) }
    arr.forEach { println(it) }
    arr.forEach(::println)

    println("--------------")

    // 不会真正的结束
    arr.forEach ForEach@{
        if (it == 2) return@ForEach
        println(it)
    }
    println("--------------")
    /*arr.forEach {
        if (it == 2) return
        println(it)
    }*/
    println("结束")

    println("-------")


    val a = a(b)
    println("a $a")

    val am = am(fun(param: Int): String {
        return param.toString()
    })
    println("am $am")
    println("am ${am(::bb)}")

    val dddd = ::bb
    println(dddd(1))


    println(d(33))
    println(dd(32))

    aaa(1);
}

fun printUsemsg() {
    println("有名函数")
}


fun checkargs(args: Array<Int>) {
    if (args.size != 2) {
        println("函数结束")
        // return 是结束函数 函数外面的还会执行
        //return
        // exitProcess 函数退出
        exitProcess(0)
    }

    println("return") // (Any) -> Unit
}

// 没有名字的函数
val longInt = fun(x: Int): Long {
    return x.toLong()
} // (Int) -> Long

fun sum(arg1: Int, arg2: Int) = arg1 + arg2

// Lambda表达式
var sum2 = { arg1: Int, arg2: Int -> arg1 + arg2 }

// 返回最后一行返回的值
var sum3 = { arg1: Int, arg2: Int ->
    println("$arg1 + $arg2 = ${sum(arg1, arg2)}")
    arg1 + arg2
}
// (Int,Int)->Int


fun a(str: (String) -> String): String {
    return str.toString()
}

fun bb(param: Int): String {
    return param.toString()
}

val b = { str: String -> str }

fun am(funParam: (Int) -> String): String {
    return funParam(1)
}


val d = fun(param: Int): String {
    return param.toString()
}

val dd = { param:Int -> param.toString()}

val ddd :(Int) -> String = {
    it.toString()
}

val aaa = fun (param: Int): String {
    return param.toString()
}




