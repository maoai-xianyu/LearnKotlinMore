package cn.kotlinlearn.K03abstractInterface

/**
 * Created by zhangkun
 * on 2017/6/2.
 */

/**
 *
 * Kotlin 中的类默认不可继承，但抽象类本身就是为继承设计的，因此 即使不用 open 关键字修饰，抽象类也是可以被继承的 ，
 * 同样，使用 abstract 关键字修饰的抽象函数也可以不加 open。但是抽象类中的非抽象方法如果不用 open 修饰的话，还是不能被子类覆盖。
 */
abstract class KotlinAbstract {
    var name: String = ""
    fun say(name: String) {
        println("  say +  $name")
    }
}