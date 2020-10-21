package cn.kotlinlearn.K01FunDoTest

/**
 * author:  zhangkun .
 * date:    on 2017/9/5.
 */

//除了 char 类型以外，Java 中的基本数据类型在 Kotlin 中都有相对应的数据类型，而且长度都是相同的：

//Kotlin 中的类型都是对 Java 基本类型的封装，因为 Kotlin 中不存在基本数据类型，所以不存在装箱拆箱的问题。

/**
 * Kotlin 没有自动类型转换，对于数字类型间的相互转换，可以使用这些数字类型的 to 方法：
 *Long 类型数字用大写的 L 字母标记：123456789L ；
 *Float 类型数字用 f 或 F 标记：123.456F ；
 *Kotlin 不支持八进制数字的表示方法；
 *
 */


fun main(args: Array<String>) {

    val i = 1

    val l: Long = i.toLong()

    charFun()

    stringFun()
}


/**
 * Kotlin 中的 Char 类型并不是一个数字，它是一个真正的“字符”：
 */
fun charFun() {
    val c: Char = 'c'
    println(c.toInt())
    println(c.toInt() == 1)

}

/**
 * Kotlin 的String可以视为为一个 CharArray 对象，可用来遍历字符串中的每个字符：
 * String 的函数比较少
 * Kotlin 字符串还支持特有的 字符串模板 功能，
 */
fun stringFun() {
    val s = "hello world!"
    for (c in s) {
        print(c + " ")
    }
    val i = 10
    //使用 $ 字符表示字符串模模板，它会把后面的表达式求值并插入到字符串的指定位置
    val s1 = "The value of is $i"

    //建议用一对大括号括起 $ 后的表达式，避免歧义

    val s2 = "i / 2 = ${i / 2}"
    println("s1 ==  $s1  s2 == $s2")
}