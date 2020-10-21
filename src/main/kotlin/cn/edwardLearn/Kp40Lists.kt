package cn.edwardLearn

// Kotlin list 可变的集合和不可变的
// 协变

fun main(args: Array<String>) {


    val strings = listOf("spring", "summer", "fall", "winter")

    println(strings.javaClass)


    val emptyList: List<String> = emptyList()

    println(emptyList.javaClass)
    if (!emptyList.isEmpty()) {
        println(emptyList[0])
    }

    val emptyList1: List<String> = listOf<String>()

    println(emptyList1.javaClass)
    // println(emptyList1[0])

    val notNullList: List<String> = listOfNotNull("hello", null, "goodbye")
    println(notNullList)


    //--------

    val mutableList = mutableListOf(1, 2, 3)
    println(mutableList.javaClass)
    mutableList[1] = 20
    println(mutableList)

    val arraylist = arrayListOf(1, 2, 3)
    println(arraylist.javaClass)

    val ints = intArrayOf(1, 2, 3)
    println(ints.toList())


}