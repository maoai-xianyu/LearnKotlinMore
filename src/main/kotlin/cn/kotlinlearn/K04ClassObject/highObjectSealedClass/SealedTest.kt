package cn.kotlinlearn.K04ClassObject.highObjectSealedClass

/**
 * Created by zhangkun on 2017/6/5.
 */
fun main(args:Array<String>){

    val a = SealedClass.SealedClassA("parenta", 190)
    val b = SealedClass.SealedClassB("parentb", 120)

    println(a.name + "  "+a.age)
    println(b.name + "  "+b.age)

}