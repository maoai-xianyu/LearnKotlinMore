package net.println.kotlin.chapter08.javareflections

import net.println.kotlin.chapter04.annotations.PoKo

/**
 *
 * @author zhangkun
 * @time 2020/9/17 12:11 上午
 *
 * kotlin 中使用java反射
 */

@PoKo // 可以用在普通类也可以用在数据类
data class Person(val name: String, val age: Int)

@PoKo
data class Person2(@JvmField val name: String, @Person2Field val age: Int)

// 扩展函数
fun Person.sayHello() {
    println("Person 扩展函数 hello ${this.name}")
}

fun sayHi() {
    println("包级方法....")
}

class DefaultConstructor()

fun main(args: Array<String>) {

    val clazz = Person::class.java
    val person = Person("benny", 18)
    val clazz2 = person.javaClass
    val clazz3 = person::class.java

    // 无参构造, 需要注意的是，数据可能是空指针，所以Poko的使用需要注意
    val person2 = clazz2.newInstance()
    println("访问无参构造函数 person2 ${person2.name}  --- ${person2.age}")
    //println("person2  无参数构造 虽然是val 但是会空指针 ${person2.name.length}  --- ${person2.age}")
    val person3 = clazz2.getConstructor(String::class.java, Int::class.java).newInstance("zhang", 20)
    println("访问有参构造函数 person3  ${person3.name}  --- ${person3.age}")

    // 获取属性
    val name = clazz2.getDeclaredField("name").apply { isAccessible = true }.get(person)
    println("访问属性 name  $name")
    // 修改name的值
    clazz2.getDeclaredField("name").apply { isAccessible = true }.set(person, "lidan")
    println("修改name的值 person  ${person.name}")
    // 获取无参数方法，且是public的函数，如果是private的函数需要设置 isAccessible = true
    val nameMethod = clazz2.getDeclaredMethod("getName").invoke(person3)
    println("访问无参数的方法 nameMethod  $nameMethod")
    // 获取有参数的犯法
    val personCo = clazz2.getDeclaredMethod("copy", String::class.java, Int::class.java).invoke(
        person3,
        person3.name, person3.age
    )
    println("方位有参数的方法：$personCo")

    // 默认调用无参构造方法
    val defaultConstructor = DefaultConstructor::class.java.newInstance()
    println("defaultConstructor $defaultConstructor")

    println("---------------获取扩展函数")

    // kotlin 访问不到 JavaReflectionsKt
    Class.forName("net.println.kotlin.chapter08.javareflections.JavaReflectionsKt")
        .getDeclaredMethod("sayHello", Person::class.java)
        .invoke(null, person3)

    // 包级方法
    Class.forName("net.println.kotlin.chapter08.javareflections.JavaReflectionsKt")
        .getDeclaredMethod("sayHi")
        .invoke(null)

    // 获取注解
    clazz2.getAnnotation(PoKo::class.java).let(::println)
    // 访问不到编译期的注解

    val clazzP = Person2::class.java

    clazzP.getDeclaredField("name").apply { isAccessible = true }
        .getAnnotation(JvmStatic::class.java).let { println(it) }
    clazzP.getDeclaredField("name").annotations.forEach {
        println(it)
    }
    clazzP.getDeclaredField("age").apply { isAccessible = true }
        .getAnnotation(Person2Field::class.java).let { println(it) }
    clazzP.getDeclaredField("age").annotations.forEach {
        println(it)
    }
}