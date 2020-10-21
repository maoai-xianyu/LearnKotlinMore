package net.println.kotlin.chapter04

import net.println.kotlin.chapter04.annotations.PoKo

/**
 *
 * @author zhangkun
 * @time 2020/5/27 11:11 上午
 */
@PoKo
data class CountryNew(val id: Int, val name: String)

fun main(args: Array<String>) {

    // 反射回去类, 获取空参的构造函数
    val newInstance = CountryNew::class.java.newInstance()
}