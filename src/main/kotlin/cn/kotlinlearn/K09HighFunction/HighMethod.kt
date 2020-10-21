package cn.kotlinlearn.K09HighFunction

/**
 * author:  zhangkun .
 * date:    on 2018/3/26.
 */

fun IntArray.countPositive(): Int {
    var count = 0
    this.filter {
        it > 0
    }.forEach {
        count++
    }
    return count
}


fun IntArray.countPositive2() = this.filter { it > 0 }.size