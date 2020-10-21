package cn.kotlinlearn.K04ClassObject.highObjectCompanionObject

/**
 * Created by zhangkun on 2017/6/5.
 */
class Res(val name: String) {
    companion object {
        val anonymousRes = Res("anonymous")
        fun sayHello(){
            println("   hello  ")
        }
    }

    var age = 0
    fun sayName(){
        println("  My name is  $name")
    }
}