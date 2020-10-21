package cn.kotlinlearn.K01FunDoTest

/**
 * author:  zhangkun .
 * date:    on 2017/9/5.
 */
fun sum(a: Int, b: Int): Int {
    return a + b
}

fun sumTurn(a: Int, b: Int) = a + b

//这里的 :Unit 一般省略
fun sayHello(name: String): Unit = println("My name is ${name}.")

//定义一个函数，输入一个元素，输出一个只包含这个元素的 List
fun <T> singletonList(item: T): List<T> = listOf(item)


//输入两个或三个 Int 变量，返回它们的和
fun add(a: Int, b: Int, c: Int = 0) = a + b + c

fun main(arg: Array<String>) {

    println(sum(1, 2))
    sayHello("hello word!")
    println(add(3, 1)) //默认 c 为 0，输出 4
    println(add(3, 1, 2)) //输入 c 值，不使用默认值，输出 6


    //val 声明常量，只可以赋值一次；var 声明变量，可以多次赋值。
    val name = "hello word!"
    println("My name is $name.")


}
