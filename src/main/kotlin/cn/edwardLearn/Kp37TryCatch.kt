package cn.edwardLearn

import java.math.BigDecimal

/**
 * kotlin  try  catch
 *
 *
 */
fun main(args: Array<String>) {

    println(getNumber("20"))


    println(getNumber("20.5"))
}


fun getNumber(string: String): Int {
    return try {
        Integer.parseInt(string)
    } catch (e: NumberFormatException) {
        println("caught one number")
        0
    }finally {
        println("finially")
        100
    }
}