package cn.edwardLearn

// Kotlin  collections function

fun main(args: Array<String>) {


    val strings = listOf("spring", "summer", "fall", "winter", "winter", "summer")
    val collectionList = listOf<String>("black", "blue", "red", "red", "fall")
    val ints = listOf(1, 2, 3, 4, 5)

    // strings 的最后一个元素
    println(strings.last())
    println(strings.getOrNull(5))
    println(strings.asReversed())

    println(ints.max())

    val joinList = collectionList + strings
    println(joinList)

    println("-----------------------------")

    val noDupsList = collectionList.union(strings)
    println(noDupsList)

    println("-----------------------------去掉重复元素")
    println(strings.distinct())

    println(collectionList.zip(strings))

    val mutableList = strings.toMutableList()

    mutableList.add("this is a add boy")
    println(mutableList)

}