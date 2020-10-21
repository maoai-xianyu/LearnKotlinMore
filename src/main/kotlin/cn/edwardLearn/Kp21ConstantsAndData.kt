package cn.edwardLearn


/**
 * author:  zhangkun .
 * date:    on 2018/5/30.
 */

val CREETING_CONSTANT = "Hello World!"

// 声明在的常量  是定义在top Level的String 或者 其他原生数据类型 没有自定义的getter 可以用const  编译期常量 ,还可以作为注解

const val SUBSYSTEM_DEPRECATED: String = "This subsystem is deprecated"

fun main(args: Array<String>) {

    println(CREETING_CONSTANT)


    val personA = Kp21Person("jack",14)
    println(personA)


    val person = Person("tom",12)
    val person1 = person.copy()
    println(person == person1)
    val person2 = person.copy(name = "rose", age = 3)
    println(person2)
}


