package cn.kotlinlearn.K02ClassConstructor

import cn.kotlinlearn.K02ClassConstructor.bean.Dog
import cn.kotlinlearn.K02ClassConstructor.bean.DogC
import cn.kotlinlearn.K02ClassConstructor.bean.DogG
import cn.kotlinlearn.K02ClassConstructor.bean.DogP

/**
 * Created by zhangkun on 2017/6/2.
 */
fun main(args: Array<String>) {
    dogG()
    dogP()
    dogC()
    dog()
}

/**
 *
 * Kotlin 中所有类的最终父类是 Any，而非 Java 中的 Object；
 * Kotlin 中 非抽象类默认不可继承；
 * Kotlin 中 非抽象类函数和类属性默认不可覆盖
 */


//---------------
fun dogG() {
    val d = DogG("DogG")
    println("  d  $d")
    println("  d  " + d.age)
    println("  d  " + d.name)
    println("  d  " + d.desc)
    println("  d  " + d.say())
    println("  d  " + d.speak())

    println("-----------------")
}


fun dogP() {
    val p = DogP("dogP")
    println("  p  $p")
    println("  p  " + p.age)
    println("  p  " + p.desc)
    println("  p  " + p.name)
    println("  p  " + p.say())
    println("  p  " + p.speak())
    println("  p  " + p.talk())

    println("-----------------")

}


fun dogC() {
    val c = DogC("dogC")
    c.desc = "龟儿子"
    println("  c  $c")
    println("  c  " + c.age)
    println("  c  " + c.name)
    println("  c  " + c.say())
    println("  c  " + c.speak())
    println("  c  " + c.desc)

    println("-----------------")

}


fun dog() {
    val d = Dog("dog")
    println("  d  $d")
    println("  d  " + d.age)
    println("  d  " + d.name)
    println("  d  " + d.say())
    println("  d  " + d.speak())
    println("  d  " + d.desc)
}
