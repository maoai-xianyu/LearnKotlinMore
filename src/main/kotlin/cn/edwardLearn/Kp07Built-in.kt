package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/29.
 *
 * Any  是所有类的根
 *
 * Unit  相当于 java void     a singleton
 *
 *
 * Nothing  kotlin 特有的 是所有类的子类型  没有 instance  一个函数返回nothing ,就用于不返回。 空类型
 *
 */
fun main(args: Array<String>) {
    val d = 10.02

    val a = 10f

    val b = 10.2f

    println("d $d  + f a $a+ b  $b ")

    val f: Byte = 10

    val q: Short = 10

    val e = 10

    // 必须是显示转换
    //val c :Char = 65
    val c: Char = 65.toChar()
    println("c $c ")


    val myLong: Long = e.toLong()

    val h: Long = myLong + e

    println("myLong $myLong  h$h")

    val stu = Stu("jack", 12)

    val isMain = true

    println(" isMain is  ${isMain is Boolean}")
    println(stu.gender(isMain))

    nothingFun()

}

fun nothingFun(): Nothing {

    println(" this is nothing")

    throw RuntimeException("Something went wrong")
}