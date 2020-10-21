package cn.kotlinlearn.K02ClassConstructor

import cn.kotlinlearn.K02ClassConstructor.bean.Parent
import cn.kotlinlearn.K02ClassConstructor.bean.Student

/**
 * author:  zhangkun .
 * date:    on 2017/9/13.
 */
fun main(args: Array<String>) {
    doMainFun()
}

//-------------------实体类
/**
 * 不使用 new 关键字：
 * Kotlin 把构造函数分为 主构造函数 和 次构造函数，主构造函数写在类头中，有且只有一个；
 * 次构造函数写在类语句中，可以有多个，也可以没有。
 */
fun doMainFun() {

    val student = Student(1000L)

    println(" id " + student.id)
    println(" name " + student.name)

    val stu = Student("坤")

    println(" id " + stu.id)
    println(" name " + stu.name)

    val stu01 = Student(12234L, "娜娜")

    println(" id " + stu01.id)
    println(" name " + stu01.name)


    var p = Parent()
    println(" id " + p.id)
    println(" name " + p.name)

    p = Parent("test")
    println(" id " + p.id)
    println(" name " + p.name)


}

