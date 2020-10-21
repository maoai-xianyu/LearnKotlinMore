package cn.edwardLearn

fun main(args: Array<String>) {

    val kp52Car = Kp52Car("Test","yellow",1)

    val array = arrayOf("hello","world")

    kp52Car.variableMethod(*array)

    println(kp52Car.variableMethod(*array))

    println("----------------------")

    kp52Car.wantsIntArray(intArrayOf(1,2,3,4))
    kp52Car.wantsIntArray(arrayOf(1,2,3,4).toIntArray())

}