package cn.edwardLearn

import org.joda.time.DateTime


/**
 * author:  zhangkun .
 * date:    on 2018/6/7.
 * 没有构造函数  线程安全的单利
 */

object SingleTonsClass {

    val currentYear = DateTime.now().year

    fun getTag() = "this is an example"

    fun getCopyright() = "Copyright \u00A9 ${currentYear}"

}