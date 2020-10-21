package cn.edwardLearn

// Kotlin  set

fun main(args: Array<String>) {

    val intSet = setOf(10, 15, 18, 5, 1, -12)
    println(intSet.javaClass)
    println(intSet.plus(20))
    println(intSet.plus(15))
    println(intSet.minus(15))
    println(intSet.minus(100))
    println(intSet.average())
    println(intSet.drop(3))
    println("the original intset : $intSet")

    println("--------------------")

    val mutableIntSet = mutableSetOf(1, 3, 5, 7, 9, 19)
    println(mutableIntSet.javaClass)
    println(mutableIntSet.plus(16))  // 不改变原有的数据，只是返回一个新的数据源

    println(mutableIntSet.add(16))  // mutableIntSet 中添加数据
    println(mutableIntSet.remove(19))  // mutableIntSet 中添加数据

    println("the mutableIntSet intset : $mutableIntSet")
}