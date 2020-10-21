package net.println.kotlin.chapter09

/**
 *
 * @author zhangkun
 * @time 2020/10/19 1:28 下午
 */
fun main(args: Array<String>) {
    // 协变点  Number 和 1，2，3，4 是父类和子类的关系
    val numbserList:List<Number> = listOf(1,2,3,4)

    // 逆变点 Comparable<Int> 是 Comparable<Any> 的父类
    // 逆变是与泛型实参的继承关系反过来
    val intComparable:Comparable<Int> = object :Comparable<Any>{
        override fun compareTo(other: Any): Int {
            return 0
        }
    }

    // 可读写的类型
    val numberArrayList:MutableList<Int> = mutableListOf(1,2,3,4)
}