package cn.edwardLearn

/**
 * 区间  range to
 *
 * while do while  和java的一样
 *
 *
 * for 不用了
 *
 *
 *
 */
fun main(args: Array<String>) {

    val intRange = 1..5
    val cahrRange = 'a'..'z'

    for (number in intRange) {
        println(number)
    }

    println("--------------")

    val intDownToRange = 5 downTo 1
    for (number in intDownToRange) {
        println(number)
    }
    println("--------------")
    val intReverseRange = intRange.reversed()

    for (number in intReverseRange) {
        println(number)
    }
    println("--------------")

    val weekdays = arrayOf("Mon","Tue","Wed","Thur","Fri")

    for (index in 0 until weekdays.size){
        println(weekdays[index])
    }

    println(3 !in 5..10)
}