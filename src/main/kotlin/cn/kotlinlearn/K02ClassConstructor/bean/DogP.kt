package cn.kotlinlearn.K02ClassConstructor.bean


/**
 * Created by zhangkun on 2017/6/2.
 * override 关键字用在定义 子类覆盖父类函数和属性 之前，用来标记覆盖了父类的函数和属
 *
 */
open class DogP(name: String) : DogG(name) {
    override val desc = "父亲"
    override var age = 0
    override fun say() = "I am DogP named $name,$age years old"

    final override fun speak() = "I am DogP named $name,$age years old"

    fun talk() = "I am DogP named $name talk with you!"

}