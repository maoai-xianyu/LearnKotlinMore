package cn.kotlinlearn.K09HighFunction

/**
 * author:  zhangkun .
 * date:    on 2018/4/10.
 *
 *
 * search
 *
 *
 * 1.firstOrNull
 * 2.lastOrNull
 * 3.first()
 * 4.last()
 * 5.indexOfFirst()
 * 6.dexOfLast()
 * 7.axBy() 与
 * 8.minBy()  maxBy()  能够找到最大和最小的元素
 */

fun main(array: Array<String>) {
    println(searchFun())
    println("--------------------------")


    var array = intArrayOf()
    println("null " + searchFirstOrNullFun(array))

    array = intArrayOf(1, 2, 4, 5, 6)
    println("not null " + searchFirstOrNullFun(array))

    println("--------------------------")

    maxByFun()

    println("--------------------------")
    val intArray = intArrayOf(0, 2, 3, 5, 4)
    findMissingNum(intArray)

    println("--------------------------")
    val intNumsArray = intArrayOf(1, 2, 3, 6, 8, 9, 6)
    findDuplicateNums(intNumsArray)
    findDuplicateNums2(intNumsArray)

}


fun searchFun(): Int {

    val array = intArrayOf(1, 5, 3)

    return array.findLast { it % 2 == 1 } ?: -1
}

fun searchFirstOrNullFun(array: IntArray): Int {

    return array.firstOrNull { it % 2 == 1 } ?: -1
}


fun maxByFun() {
    val stu = arrayOf(
            Stu("sada", 12),
            Stu("dfasdfs", 56),
            Stu("asd", 33)
    )

    val oldest = stu.maxBy { it.age }!!
    println("Oldest one is ${oldest.name}")
}

// 给一个长度为 n 的整数数组，其中元素依次为从 0 到 n 的整数，要求找出缺失的数字。
fun findMissingNum(nums: IntArray) {
    val first = nums.indices.first { it != nums[it] }
    println(" 缺失 $first")
}

// 长度为 n+1 的数组 nums，包含从 1 到 n 的整数，只有一个数字出现了两次；
fun findDuplicateNums(nums: IntArray) {
    val set = mutableSetOf<Int>()
    val first = nums.first { !set.add(it) }
    println(" 重复 $first")
}

fun findDuplicateNums2(nums: IntArray) {
    nums.sort()
    //val index1 = (0..nums.lastIndex -1).first { nums[it] == nums[it + 1] }
    val index = (0 until nums.lastIndex).first { nums[it] == nums[it + 1] }
    println(" 重复 ${nums[index]}")
}
