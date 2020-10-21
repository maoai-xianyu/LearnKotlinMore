package net.println.kotlin.chapter09

/**
 *
 * @author zhangkun
 * @time 2020/10/19 11:34 下午
 */
fun main() {
    // 协变  Any
    val list: List<*> = listOf(1, 2)
    // Any
    val any = list[1]

    // 逆变 nothing
    val comparable: Comparable<*> = object : Comparable<Any> {
        override fun compareTo(other: Any): Int {
            return 0
        }
    }
    // 所有类型的子类  Nothing
    //comparable.compareTo()

    val mutableList: MutableList<*> = mutableListOf(1, 2, 3)
    // 协变 返回Any
    mutableList[1]
    // set(index,Nothing) 逆变
    //mutableList.set(1,)

    //hello<*>() 错误
    //Hello<*>() 错误
}

fun <T> hello() {}

open class Hello<T>

class Hello2<T>

class SonHello : Hello<Hello2<*>>()