package cn.kotlinlearn.K05Null.nullPoint

import cn.kotlinlearn.K02ClassConstructor.bean.Student
import java.io.File
import java.math.BigDecimal
import java.math.RoundingMode

/**
 * Created by zhangkun on 2017/6/5.
 *
 * 可空类型与非空类型
 * 所有数据类型默认都是非空（non-null）的，如果想把 null 赋给它们的对象，需要在类型后加上 ? ，声明为可空类型
 */
fun main(arg: Array<String>) {

//    var mm: String? = null
//
//    printLengthOfString(mm)
//
//    mm = "test"
//
//    printLengthOfString(mm)
//
//    elvisFun()
//
//    letFun()
//
//    notNullFun()



    testNull(null)
    testNull("ss")


    testNullInfo()
    testDuoble()
}

// 安全调用符 ?.
/**
 * 如果一个可空变量已经被判断为非空，再次调用它的方法和变量时，会自动将变量转换为非空类型，实现安全调用
 *
 */
fun printLengthOfString(s: String?) = println(s?.length)


//------------Elvis 操作符 ?:    if null then  或者 用let
fun elvisFun() {

    val list = ArrayList<String>()
    println(list?.size ?: "null")

    val listFiles = File("./folder").listFiles()
    println(listFiles?.size ?: "Empty")
    println(listFiles?.let { listFiles.size } ?: "Empty")

    val listFiles1 = File("app/src/main/java/com/mao/cn/kotlinlearn/K05Null/nullPoint/folder").listFiles()
    println(listFiles1?.size ?: "Empty")
    println(listFiles?.let { listFiles.size } ?: "Empty")

    val file = File("app/src/main/java/com/mao/cn/kotlinlearn/K05Null/nullPoint/folder/Test1.kt")
    println("file   " + file.exists())



}

//---------- let  安全调用符 + let 函数就等同于 if not null then 语句。
fun letFun() {

    val files = File("app/src/main/java/com/mao/cn/kotlinlearn/K05Null/nullPoint/folder").listFiles()
    files?.let {
        for (file in files) {
            println(file.name)
        }
    }
}

//----------非空操作符 !!  Kotlin 不建议在代码中广泛使用 !! 操作符，这会浪费 Kotlin 设计良好的非空类型，让 Kotlin 代码充斥着 NPE。
fun notNullFun() {
    println("-----------------------")
    val files = File("app/src/main/java/com/mao/cn/kotlinlearn/K05Null/nullPoint/folder").listFiles()!!
    for (file in files) {
        println(file.name)
    }

    val filesFolder = File("folder").listFiles()!!
    for (file in filesFolder) {
        println(file.name)
    }
}


fun testNull(str:String?){

    println(str?.length)
    println("------")
    if (str == "")
    println(str ?: "enpty")
    println(str?.let { it } ?: "enpty")
}


fun testNullInfo(){

    var student :Student ?= null


    println(student?.name)


}

fun testDuoble(){
    val bg = BigDecimal(23.00).setScale(2, RoundingMode.UP)
    val num = bg.inc().toDouble()
    println("num $num")

}