package cn.kotlinlearn.K08TypeExtension

import cn.kotlinlearn.K08TypeExtension.isOdd
import cn.kotlinlearn.K08TypeExtension.swap

/**
 * author:  zhangkun .
 * date:    on 2018/3/21.
 */
fun main(array: Array<String>) {
    val list = mutableListOf(1, 2, 3)
    list.swap(0, 1)

    println(list)

    val n = 0
    println(n.isOdd)
}