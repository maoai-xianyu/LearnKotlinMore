package net.println.kotlin.chapter10.sam

import kotlin.chapter10.sam.PersonM
import kotlin.chapter10.sam.SAMInJava

/**
 *
 * @author zhangkun
 * @time 2020/10/21 11:15 下午
 */
fun main(args: Array<String>) {

    val person = PersonM()
    person.address = "ssss"
    person.name = "ssss2"

    val samInJava = SAMInJava()

    // lambda 表达式
    //samInJava.addTask { println("h") }

    val lambda = { println("hhh") }
    // 每次添加的都是一个新的表达式，因为在编译的时候，lambda 被强转为 Runnable
    // SAM 支持 kotlin 调用java的接口，不支持 kotlin 的接口,可以定义类型别名
    samInJava.addTask(lambda)
    samInJava.addTask(lambda)
    samInJava.addTask(lambda)
    samInJava.addTask(lambda)

    samInJava.removeTask(lambda)
    samInJava.removeTask(lambda)
    samInJava.removeTask(lambda)
    samInJava.removeTask(lambda)

    val samInKotlin = SAMInKotlin()
    samInKotlin.addTask {
        println("h")
    }
}

