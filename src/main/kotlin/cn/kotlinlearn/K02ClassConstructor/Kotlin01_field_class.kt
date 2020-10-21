package cn.kotlinlearn.K02ClassConstructor

import cn.kotlinlearn.K02ClassConstructor.bean.Child
import cn.kotlinlearn.K02ClassConstructor.bean.Stu
import cn.kotlinlearn.K02ClassConstructor.bean.maxID
import cn.kotlinlearn.K02ClassConstructor.bean.minID

/**
 * Created by zhangkun on 2017/5/26.
 */

fun main(args: Array<String>) {
    stuFun()
    childFun()
    stuDetail()
}


/**
 * Kotlin 中允许 包级属性 的存在，即属性不一定在类里；
 * 所有非抽象属性都强制要求初始化，没有初始化的属性无法通过编译（除标记为 lateinit var 的属性外）；
 * 标准化的 getter 和 setter；
 * 大量的高级属性修饰符
 */
//----------------实体类  setter 和 getter
fun stuFun(){
    val stu = Stu("text")
    stu.name = "gjjjh"
    println(" stu "+stu.isValidName)
    println(" stu "+stu.name)
    val test : String = "try"
    println("   "+test[0].toUpperCase()+test.substring(1))
}

//类外属性
// 一是直接写在类外并初始化的包级属性，
// 二是使用 const val 定义的 编译期常量。
// 一、在类外定义的包级属性，会被编译为一个“文件类”的静态变量：

fun childFun(){
    val a = maxID

    println("a  $a")

    val b = minID

    println("b  $b")
}


fun stuDetail(){
    val stu = Child("Detail")
    println("stu "+stu.name)
    stu.initHello()
    println("stu "+stu.hello)
}