package cn.kotlinlearn.K07Collection.collections

import cn.kotlinlearn.K01FunDoTest.singletonList
import java.util.*

/**
 * Created by zhangkun on 2017/6/7.
 */
fun main(args: Array<String>) {
    listFun()
    println("-------------------")
    mutableListFun()
    println("-------------------")
    listOfNotNullFun()

    println("-------------------")
    arrayListFun()
}


fun listFun() {

    val listEmpty = emptyList<String>()

    println(listEmpty?.size ?: "empty")

    val listSingle = singletonList("text")

    println(message = listSingle[0])


    val string = arrayOf("TE3", "TE54", "TE1", "TE5", "TE7")

    val list = listOf(*string)
    //val list = listOf(string)  是数组对象

    list.forEach {
        println(it)
    }


    //这叫 展开操作符，一般来说，我们给 vararg 函数传参数时，只能一个一个地传，
    // 如果想把一个数组传给 vararg 参数，可以在数组前面加个 *，
    // 告诉编译器：“我不是把数组对象作为参数，而是把数组里的每个元素作为参数”，可以这样写：



}

fun mutableListFun() {

    val list = mutableListOf<String>()
    list.add("测试")
    list.add("list")
    list.add("测试list")
    list.add("测试")

    list.forEach {
        println(it)
    }


    println("-------------------")

    val listm = listOf("sdsd", "asdasd", "ASdasda", "ASdasd")

    listm.forEach {

        println(it)
    }

    val last = listm.last()


    println("  last    $last")


    val subList = listm.subList(0, 2)
    subList.forEach {

        println(it)
    }

}

fun listOfNotNullFun() {

    val list = listOfNotNull("", "s", null, "ddssda", null)
    list.forEach {

        println("  ces  $it")
    }

}

fun arrayListFun() {


    val list = arrayListOf<Any>()

    list.add("zhang")
    list.add(1)
    list.add(true)

    list.forEach {
        println("-- $it")
    }


    val listLink = LinkedList<String>()

    listLink.add("Sdsd")
    listLink.add("asda")
    listLink.add("lklklk")
    listLink.add("o oqo")

    listLink.forEach {
        println("-- $it")
    }
}