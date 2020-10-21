package cn.kotlinlearn.K03abstractInterface

import cn.kotlinlearn.K03abstractInterface.impl.KotlinInterfaceImpl

/**
 * Created by zhangkun on 2017/6/5.
 */
fun main(args: Array<String>){

    val inter = KotlinInterfaceImpl()
    inter.prop = 100
    println(" ----  "+inter.prop)
    inter.foo(1000)
    inter.bar()
    println(" ----  "+inter.mms)

}