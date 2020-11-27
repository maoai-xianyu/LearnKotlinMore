package net.println.kotlin.chapter05

fun main(args: Array<String>) {

    val person =Person("zzz",1);
    val letName = person.let {
        val name = person.name
        1
        println("name $name")
    }
    println("let 方法体内是 it 返回的是表达式里面最后一行返回的值 $letName")

    val runName = person.run {
        val name = person.name
        1
        println("name $name")
    }
    println("let 方法体内是 this 返回的是表达式里面最后一行返回的值 $runName")


    val alsoName = person.also {
        val name = person.name
        1
        println("name $name")
    }
    println("also 方法体内是 it 返回的是当前调用的对象 $alsoName")

    val applyName = person.apply {
        val name = person.name
        1
        println("name $name")
    }
    println("also 方法体内是 this 返回的是当前调用的对象 $applyName")
}