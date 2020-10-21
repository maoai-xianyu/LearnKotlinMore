package cn.kotlinlearn.K09HighFunction

/**
 * author:  zhangkun .
 * date:    on 2018/4/10.
 */

fun main(array: Array<String>) {
    val nums = 7
    val findDisappearNumbers = findDisappearNumbers(nums = IntArray(nums))
    println("------------------$findDisappearNumbers")
}


fun findDisappearNumbers(nums: IntArray): List<Int> {
    val ifAppear = BooleanArray(nums.size + 1)
    nums.forEach {
        ifAppear[it] = true

        println("值 $it")
    }
    ifAppear.forEach {
        println(it)
    }

    /*return ifAppear.mapIndexed { index, boolean ->
        if (boolean || index == 0) -1 else index
    }.filter { it != -1 }*/

    return ifAppear.mapIndexed { index, b ->
        if (b || index == 0) -1 else index
    }.filter { it != -1 }
}