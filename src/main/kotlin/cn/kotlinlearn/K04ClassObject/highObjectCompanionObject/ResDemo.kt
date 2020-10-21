package cn.kotlinlearn.K04ClassObject.highObjectCompanionObject

/**
 * Created by zhangkun on 2017/6/5.
 */
fun main(args:Array<String>){


    val res = Res("res")
    println(res.name)
    res.sayName()

    Res.sayHello()

    println("------------- "+ Res.Companion.anonymousRes.sayName())
    println("------------- "+ Res.Companion.sayHello())

    Res.anonymousRes.sayName()
    /**
     * 使用伴生对象实际上是在这个类内部创建了一个名为 Companion 的静态单例内部类，
     * 伴生对象中定义的属性会直接编译为外部类的静态字段，而函数会被编译为伴生对象的方法。
     */

    println("----------------------------- ")

    val resources = Resources("test")
    println(" resources "+resources.name)
    resources.sayHello()

    println(" resources anonymous "+ Resources.anonymous)

    Resources.say()
    println(" -------------------")
    Resources.say()

}