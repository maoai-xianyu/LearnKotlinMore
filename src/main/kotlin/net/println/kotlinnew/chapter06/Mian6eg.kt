package net.println.kotlinnew.chapter06

import java.io.File

/**
 *
 * @author zhangkun
 * @time 2020/6/11 4:18 下午
 */

fun main(args: Array<String>) {

    val person = Person6("zl",2)
    val let = person.let {
        println(it.name)
        "let this return last line"
    }
    println("let $let")

    val run = person.run {
        println(this.name)
        "run  this run last line"
    }
    println("run $run")

    person.let(::println)
    person.run(::println)
    val also = person.also {
        it.name = "大南"
    }
    println(also.name)

    val apply = person.apply {
        name = "大南"
    }
    println(apply.name)

    File("build.gradle").inputStream().reader().buffered()
        .use {
            println(it.readLines())
        }
}


class Person6(var name:String,var age:Int)