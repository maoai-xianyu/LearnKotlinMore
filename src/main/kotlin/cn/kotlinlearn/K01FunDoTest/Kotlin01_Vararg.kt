package cn.kotlinlearn.K01FunDoTest

/**
 * author:  zhangkun .
 * date:    on 2017/9/5.
 */

fun main(arg: Array<String>) {

    println("add  vararg" + add(1, 2, 4, 5, 6, 7, 7))
    println("addSimple vararg" + addSimple(1, 2, 4, 5, 6, 7, 7))

}

//使用 vararg 修饰参数列表的最后一项，表示这个参数的数量是可变的，与 Java 中的“形参类型.. 形参名”相同
fun add(a: Int, b: Int, vararg n: Int): Int {
    var sum = a + b
    for (i in n) {
        sum += i
    }
    return sum
}

fun addSimple(a: Int, b: Int, vararg n: Int): Int {
    val sum = a + b + n.sum()
    return sum
}