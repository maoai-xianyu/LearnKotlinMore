package cn.kotlinlearn.K04ClassObject.highObjectCompanionObject

/**
 * Created by zhangkun on 2017/6/5.
 * 伴生对象
 * Kotlin 中的对象指的是使用 object 关键字定义的 类型声明，一般用作单例模式和伴生对象
 */
object Resource{
    val name = "alex"
    fun say(){
        println("  hello  ")
    }
}