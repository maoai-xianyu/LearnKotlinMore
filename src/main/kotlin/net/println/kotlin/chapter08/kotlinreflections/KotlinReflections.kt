package net.println.kotlin.chapter08.kotlinreflections

import net.println.kotlin.chapter04.annotations.PoKo
import net.println.kotlin.chapter08.javareflections.Person2Field
import kotlin.reflect.KMutableProperty1
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberExtensionFunctions
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

/**
 *
 * @author zhangkun
 * @time 2020/9/17 12:11 上午
 *
 * kotlin 中使用java反射
 */

@PoKo // 可以用在普通类也可以用在数据类
data class Person(val name: String, var age: Int) {

    // 定义在类里面的扩展方法
    fun String.times(a: Int) {

    }
}

@PoKo // 可以用在普通类也可以用在数据类
open class Person2(@JvmField val name: String, @KPerson2Field val age: Int)
class Engineer(name: String, age: Int) : Person2(name, age)

// 扩展函数
fun Person.sayHello() {
    println("Person 扩展函数 hello ${this.name}")
}

fun sayHi() {
    println("包级方法....")
}

class NoPrimaryConstructor {

    // 这种情况下没有 primaryConstructor
    constructor() {
        println("not primary,no arg")
    }

    constructor(i: Int) {
        println("not primary, arg $i")
    }
}

class DefaultConstructor()

fun main(args: Array<String>) {

    println("kotlin reflections------")

    val kClass = Person::class
    val kClazz = Person::class.java
    val person = Person("benny", 18)
    // 为啥返回的是协变的参数类型  out Person,原因是我们的通过实例获取的class
    val kClass2 = person::class  // 逆变点是in  协变点是 out
    val kClass3 = person.javaClass.kotlin // 使用 person
    // 无参构造函数 primaryConstructor 可以为空
    val primaryConstructor = kClass2.primaryConstructor
    println("primaryConstructor $primaryConstructor")
    val kPerson = primaryConstructor!!.call("zhang", 39)
    println("kPerson $kPerson")

    println("没有主构造器 start------")
    val kNoClass = NoPrimaryConstructor::class
    val primaryConstructor1 = kNoClass.primaryConstructor
    println("primaryConstructor1 primaryConstructor为空 $primaryConstructor1")
    kNoClass.constructors.forEach(::println)
    kNoClass.constructors.first().call()
    kNoClass.constructors.last().call(20)
    println("没有主构造器 end ------")

    println("访问属性")
    // 访问属性 out Person
    kClass2.memberProperties.forEach(::println)
    // out Person 所以  get(receiver:Nothing) 需要改成  kClass2 -> kClass
    //kClass2.memberProperties.first { it.name =="name" }.get(person).let { println(it) }
    kClass.memberProperties.first { it.name == "name" }.get(person).let(::println)

    println("访问可变属性")
    // 获取属性  KMutableProperty1Impl 是可变的
    kClass.memberProperties.forEach {
        //println(it.javaClass)
        //println(it::class.java)
        println(it::class)
    }
    // KMutableProperty1Impl 的 父类 KMutableProperty1 是可以读写的 var
    (kClass.memberProperties.first { it.name == "age" } as? KMutableProperty1<Person, Int>)
        ?.set(kPerson, 12)
    println(kPerson)

    println("访问方法和函数")
    // function
    kClass.memberFunctions.forEach(::println)
    println("扩展方法-------")
    // memberExtensionFunctions 返回定义在类里面的扩展方法，获取不到外面的扩展方法
    // 包级函数不建议用反射调用
    kClass.memberExtensionFunctions.forEach {
        println(it)
    }
    println("kotlin注解-----")
    kClass.annotations.forEach(::println)
    // 获取
    val person2 = Person2("benny", 18)
    val kP = Person2::class
    println("kotlin 成员属性注解----")
    //
    val kPerson2 = person2.javaClass.kotlin
    kPerson2.memberProperties.first { it.name =="name" }.annotations.forEach(::println)
}