package cn.kotlinlearn.K09HighFunction

/**
 * author:  zhangkun .
 * date:    on 2018/4/10.
 */

fun main(array: Array<String>) {

    val string = "sHorT SEntEncE"
    println(mapToFun(string))

    println("--------------------")

    println(mapToFun2(string))

}


fun mapToFun(s: String): String {
    return s.split(" ").map {
        it[0].toUpperCase() + it.substring(1).toLowerCase()
    }.joinToString(separator = " ")
}

fun mapToFun2(s: String): String {
    return s.split(" ").joinToString(separator = " ") {
        it[0].toUpperCase() + it.substring(1).toLowerCase()
    }
}