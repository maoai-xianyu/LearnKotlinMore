package cn.kotlinlearn.K04ClassObject.highObjectCompanionObject

/**
 * Created by zhangkun on 2017/6/5.
 *
 * @JvmStatic 注解只能用在伴生对象里，修饰伴生对象内的属性和函数，用来告诉编译器将属性和函数编译为真正的 JVM 静态成员。
 * 需要注意到，如果在伴生对象声明里使用@JvmStatic 注解，那么没有加该注解的属性和函数将不会被编译为静态成员：
 */
class Resources(val name: String) {
    companion object {
        @JvmStatic val anonymous = Resources("anonymous")

        fun say() = println("hello")
    }

    override fun toString(): String {
        return "Resources(name='$name')"
    }


    fun sayHello(){
        println(" Resources hello")
    }

}