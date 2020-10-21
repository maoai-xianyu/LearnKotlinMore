package net.println.kotlinnew.chapter03

/**
 *
 * @author zhangkun
 * @time 2020/4/10 9:12 上午
 */

fun main(args: Array<String>) {

    if (args.size > 3) {
        return sayHello()
    }

    val oper = mapOf(
        "+" to ::plus,
        "-" to ::minus,
        "*" to ::multiply,
        "/" to ::divide
    )

    val func = oper[args[1]]
    if (func != null) {
        try {
            val result = func(args[0].toInt(), args[2].toInt())
            println("result $result")
        } catch (e: Exception) {
            return sayHello()
        }
    } else {
        return sayHello()
    }

}

fun plus(arg1: Int, arg2: Int): Int {
    return arg1 + arg2
}


fun minus(arg1: Int, arg2: Int): Int {
    return arg1 - arg2
}


fun multiply(arg1: Int, arg2: Int): Int {
    return arg1 * arg2
}


fun divide(arg1: Int, arg2: Int): Int {
    return arg1 / arg2
}

fun sayHello() {
    println(
        """
        Please input
        input: 3 * 4
        output: 12
    """.trimIndent()
    )
}