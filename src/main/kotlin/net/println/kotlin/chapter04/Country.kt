package net.println.kotlin.chapter04

/**
 *
 * @author zhangkun
 * @time 2020/5/27 11:11 上午
 */

data class Country(val id: Int, val name: String)

class ComponentX {

    // 操作符重载
    operator fun component1(): String {
        return "你好，我是"
    }

    operator fun component2(): Int {
        return 1
    }

    operator fun component3(): Int {
        return 2
    }

    operator fun component4(): Int {
        return 2
    }
}


fun main(args: Array<String>) {
    val china = Country(0, "北京")
    println(china)
    // component1 可以自己定义
    println(china.component1())
    println(china.component2())

    val (id, name) = china
    println(id)
    println(name)

    val array = arrayOf("111", "2222", "3333")

    // 析构
    for ((index, value) in array.withIndex()) {
        println("$index  --- $value")
    }

    val componentX = ComponentX()
    val (a, b, c, d) = componentX
    println("$a $b$c$d")

}