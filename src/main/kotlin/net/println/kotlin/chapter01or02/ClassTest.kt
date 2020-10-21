package net.println.kotlin.chapter01or02

/**
 *
 * @author zhangkun
 * @time 2020/4/9 12:41 上午
 */


class A {
    var b = 0
        get() {
            println("get 方法")
            return field
        }
        set(value) {
            println("set 方法")
            field = value
        }
}

class ClassTest {
    var b = 0;
    lateinit var c: String
    lateinit var a: A
    val aa: A by lazy {
        println("init a")
        A()
    }
}

fun main(args: Array<String>) {
    println("start")
    val clazz = ClassTest()
    println("init a")
    println(clazz.b)
    println(clazz.aa)

}

