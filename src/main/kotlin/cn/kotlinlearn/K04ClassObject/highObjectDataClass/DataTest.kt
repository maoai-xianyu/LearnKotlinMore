package cn.kotlinlearn.K04ClassObject.highObjectDataClass

import cn.kotlinlearn.K04ClassObject.highObjectDataClass.DataP

/**
 * Created by zhangkun on 2017/6/5.
 */
fun main(args: Array<String>) {
    val a = DataP("alex",16)

    println(a.toString())

    //copy() 函数：这个函数让我们可以复制一个对象，然后修改一下属性。
    val b = a.copy(name = "malex")

    println(b.toString())



    //componentN() 函数：这里的 N 与主构造函数中声明的属性数是相同的，这种函数叫做 析构函数
    val (name,age) = a

    println("$name is age $age")

}