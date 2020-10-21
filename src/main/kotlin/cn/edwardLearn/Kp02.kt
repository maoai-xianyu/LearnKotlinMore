package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/24.
 *
 * kotlin 和 Java的不同
 *
 * 1. kotlin 可以不用加; Java 必须加
 * 2. Java 不允许关键字乱用   Kotlin 可以有一部分可以用  远关键字  和 近关键字
 * 3. Kotlin 可以用集合[] 访问集合的数据
 * 4. Kotlin 有自己的String class
 * 5. Kotlin 不使用 throw exception
 * 6. Kotlin 没有三元操作符
 * 7. for循环   kotlin foreach
 * 8. Kotlin 没有 static
 * 9. Kotlin 没有 new
 * 10. Kotlin 有很多wrappers 包装java语句
 */

fun main(args: Array<String>) {

    val name: ArrayList<String> = arrayListOf("JASSS", "SADASD", "ASDASD")
    println(name[1])
    println(name[1].length)

    // c = x ? y : z

    val list = arrayListOf<String>()

    println("list "+ test(list))

}

fun test(list: ArrayList<String>?): Int {

    return list?.size ?: 0
}
