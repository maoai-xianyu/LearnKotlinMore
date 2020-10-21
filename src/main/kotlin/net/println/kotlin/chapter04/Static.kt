package net.println.kotlin.chapter04

/**
 *
 * @author zhangkun
 * @time 2020/5/27 8:50 上午
 */

fun main(args: Array<String>) {

    val arrag = arrayOf("1", "3")
    val a = minOf(arrag[0].toInt(), arrag[1].toInt())

    println(" a = $a")
    val latitude = Latitude.toDouble(2.0).value

    println(" latitude = $latitude")
}


class Latitude private constructor(val value: Double) {

    // 伴生对象
    companion object {
        // 在java中调用的时候，可以不需要写 Companion
        @JvmStatic
        fun toDouble(double: Double): Latitude {
            return Latitude(double)
        }

        fun ofDouble(double: Double): Latitude {
            return Latitude(double)
        }


        @JvmField
        val TAG: String = "Latitude"

        val TAGK: String = "Latitude"
    }
}