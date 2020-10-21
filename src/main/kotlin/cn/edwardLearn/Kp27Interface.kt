package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/6/1.
 */
fun main(args: Array<String>) {


    val oneClass = OneClass()
    println(oneClass.number)
    println(oneClass.number2)

}


/**
 * 接口可以有子接口
 */
interface OneInterface {

    // 抽象属性
    val number: Int
    // 非抽象属性
    val number2: Int
        get() = number * 20

    fun oneFunction(str: String): String

}

/**
 * 接口可以有抽象属性和非抽象属性（带有自定义访问函数的属性，因为kotlin不允许接口中的属性带有初始化器）
 *
 */
interface SubInterFace : OneInterface {

    fun subFunction(num: Int): String
}

class OneClass : SubInterFace {

    override val number: Int
        get() = number2 * 2//To change initializer of created properties use File | Settings | File Templates.

    override val number2: Int = 25

    override fun oneFunction(str: String): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun subFunction(num: Int): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}