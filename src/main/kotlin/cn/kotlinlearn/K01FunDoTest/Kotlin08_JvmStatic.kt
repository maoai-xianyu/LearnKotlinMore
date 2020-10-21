package cn.kotlinlearn.K01FunDoTest

/**
 * Created by zhangkun on 2017/5/23.
 */
object Kotlin08_JvmStatic {

    fun sumX(a: Int, b: Int) = a + b

    @JvmStatic fun main(args: Array<String>) {
        print("sum 2+3 =  ${sumX(2, 3)}")
    }

}
