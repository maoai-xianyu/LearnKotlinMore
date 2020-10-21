package cn.edwardLearn

import java.math.BigDecimal

private val s = "this is a string"

/**
 * kotlin  没有 switch 用 when 代替
 *
 */
fun main(args: Array<String>) {


    val numlong:Long= 1000000
    println(numlong.toString()+"this is a long")

    val num = 600
    val y = 280
    when (num) {
        100, 600 -> println("100")
        in 100..200 -> println("$num is in the rang 100 .. 200")
        y + 20 -> println("300")
        else -> println("don`t match anything...")
    }


    val obj1: Any = "this is a string"

    val obj2: Any = BigDecimal(8.5)

    val obj3: Any = 55

    var something: Any = obj3

    when (something) {
        is String -> println(something.toUpperCase())
        is BigDecimal -> println(something.add(BigDecimal(5.1)))
        is Int -> println("$something + 5 = ${something + 5}")
    }

    val something1: Any = 11.2f
    val e = when (something1) {
        is String -> println(something1.toUpperCase())
        is BigDecimal -> println(something1.add(BigDecimal(5.1)))
        is Int -> println("$something1 + 5 = ${something1 + 5}")
        else -> println("赋值后需要 else")
    }

    val num1 = 20
    val num2 = 30
    if (num1 > num2) {
        println("num1  > num2")
    } else if (num1 < num2) {
        println("num1  < num2")
    } else {
        println("num1  == num2")
    }


    when{
        num1 > num2 -> println("num1  > num2")
        num1 < num2 ->  println("num1  < num2")
        else -> println("num1  == num2")
    }


}