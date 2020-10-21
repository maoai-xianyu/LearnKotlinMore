package cn.kotlinlearn.K01FunDoTest

/**
 * Created by zhangkun on 2017/5/23.
 */
class Kotlin09_companion_object {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println(" 3 +5  = ${sumTotal(3, 5)}")
        }

        fun sumTotal(a: Int, b: Int) = a + b
    }

}
