package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/31.
 *
 * 扩展函数
 */

fun main(args: Array<String>) {

    val utilities = Kp24Utilities()

    val str = "sdsdfsdfsdfdsf"

    println(utilities.upper3FirstAnd3Last(str))

    println(str.upper3FirstAnd3Last())
}


// 给属性扩展函数  this 可以不用写  top level
fun String.upper3FirstAnd3Last(): String {
    /*return this.substring(0, 3).toUpperCase() + this.substring(3, this.length - 3) +
            this.substring(this.length - 3, this.length).toUpperCase()*/
    return substring(0, 3).toUpperCase() + substring(3, length - 3) +
            substring(length - 3, length).toUpperCase()
}