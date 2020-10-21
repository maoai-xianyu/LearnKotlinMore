package net.println.kotlin.chapter01or02

import java.time.Year

/**
 * Created by zhangkun
 * on 2018/6/7.
 */
object SingleTonsClass{
    val currentYear = Year.now().value
    fun getTag() = "this is an example"

    fun getCopyright() = "Copyright |u00A9 $currentYear"
}