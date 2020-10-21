package cn.kotlinlearn.K01FunDoTest

/**
 * author:  zhangkun .
 * date:    on 2017/9/13.
 */
fun main(args: Array<String>) {

    println("  maxof  " + maxof(2, 3))
    println(max(2, 5))

    //------when
    whenFun(1)
    whenFun(3)
    whenFun("hello world")
    whenFunNum(2)

    //------------
    println(describe(1))
    println(describe("Hello"))
    println(describe(1000L))
    println(describe(2))
    println(describe("other"))

}


fun max(a: Int, b: Int) = if (a <= b) b else a


fun maxof(a: Int, b: Int): Int = if (a > b) {
    readLine()
    a
} else {
    b
}


fun whenFun(x: Any) {

    when (x) {
        1, 2 -> println("x = $x")
        else -> println(" x is nerther 1 0r 2")
    }

    when (x) {
        !is Int -> println("x = $x")
        in 0..10 -> println("x = $x  x is between 0 and 10")
        else -> println(" x is over 10 ")
    }

}


fun whenFunNum(x: Int) {

    val isOdd = when {
        (x and 1) == 1 -> true
        else -> false
    }

    println("  isOdd " + isOdd)
}


//----------------------------

fun describe(obj: Any): String =
        when (obj) {
            1 -> "one"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "not a string"
            else -> "Unknown"
        }
