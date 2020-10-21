package cn.kotlinlearn.K03abstractInterface

/**
 * Created by zhangkun on 2017/6/2.
 *
 */
interface KotlinInterface {
    var prop: Int
    fun foo(prop: Int)
    fun bar() {
        println("bar")
    }
    val mms:String
}
