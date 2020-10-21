package net.println.kotlin.chapter03

import java.lang.IllegalArgumentException
import java.lang.NumberFormatException
import java.lang.UnsupportedOperationException

/**
 *
 * @author zhangkun
 * @time 2020/4/10 9:12 上午
 */

fun main(args: Array<String>) {
    while (true) {
        try {
            println("请求输入算式例如：3 + 4")
            val input = readLine() ?: break
            val splits = input.trim().split(" ")
            if (splits.size < 3) {
                throw IllegalArgumentException("参数个数不对")
            }
            val arg1 = splits[0].toDouble()
            val oper = splits[1]
            val arg2 = splits[2].toDouble()
            println("$arg1 $oper $arg2 = ${Operacte(oper)
                .apply(arg1, arg2)}")
        } catch (e: NumberFormatException) {
            println("您确定输入的是数字么")
        } catch (e: IllegalArgumentException) {
            println("您确定输入的是3个参数么？")
        } catch (e: Exception) {
            println("遇到未知为异常？${e.message}")
        }

        println("再来一次？[y]")
        val cmd = readLine()
        if (cmd == null || cmd.toLowerCase() != "y") {
            break
        }
    }

    println("Thanks")

}

class Operacte(op: String) {
    val opFun: (left: Double, right: Double) -> Double

    init {
        opFun = when (op) {
            "+" -> { l, r -> l + r }
            "-" -> { l, r -> l - r }
            "*" -> { l, r -> l * r }
            "/" -> { l, r -> l / r }
            else -> {
                throw UnsupportedOperationException(op)
            }
        }
    }

    fun apply(left: Double, right: Double): Double {
        return opFun(left, right)
    }
}