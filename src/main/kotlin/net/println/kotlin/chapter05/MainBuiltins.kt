package net.println.kotlin.chapter05

import java.io.BufferedReader
import java.io.FileReader
import java.lang.StringBuilder

/**
 *
 * @author zhangkun
 * @time 2020/5/27 6:09 下午
 * 高阶函数
 */

fun main(args: Array<String>) {

    println("----forEach---")
    val list = listOf(1, 2, 3, 4, 5, 6, 7)
    list.forEach(::print)

    println("----map---")
    // 类型转哈
    val newlist = list.map {
        "no ${it * 2 + 3} "
    }
    val newlist1 = list.map(Int::toDouble)
    newlist.forEach(::print)

    val list1 = listOf(1..3, 2..5, 10..12)
    list1.forEach(::println)

    println("----flatMap---")
    val list3 = list1.flatMap {
        it.map { element ->
            "No. $element"
        }
    }
    list3.forEach(::println)
    println("-------------------")
    // flatMap 把集合的集合打开
    val list2 = list1.flatMap {
        it
    }
    list2.forEach(::println)

    println("------reduce-------")
    // 求和
    val reduce = list2.reduce { acc, i ->
        println(" accc $acc  ---- i $i")
        acc + i
    }
    val ssss = list2.reduce(sum2)
    println("reduce 求和 $reduce" + "ssss  $ssss")
    println("-------------")

    (0..6).map(::factorial).forEach(::println)
    println("-------------")
    val reduce1 = (0..6).map(::factorial).reduce { acc, i ->
        println(" accc $acc  ---- i $i")
        acc + i
    }
    println("reduce1 阶机遇求和的结果 $reduce1")

    println("-------fold------")
    // 赋初始值
    val fold = (0..6).map(::factorial).fold(5, { acc, i -> acc + i })
    val fold1 = (0..6).map(::factorial).fold(5) { acc, i -> acc + i }

    println("fold 初始值 $fold  fold1  $fold1")
    println("-------------")
    val fold3 = (0..6).map(::factorial).fold(StringBuilder()) { acc, i ->
        acc.append(i).append(",")
    }
    println(fold3)

    println("------joinToString------")
    val joinToString = (0..6).joinToString(",")
    println(joinToString)

    val takeWhile = (0..6).map(::factorial).takeWhile { it % 2 == 1 }
    println(takeWhile)


    val person = findPerson()

    // let 返回当前对象
    person?.let { person ->
        {
            println(person.name)
            println(person.age)
        }
    }

    person?.let { (name, age) ->
        {
            println(name)
            println(age)
        }
    }

    person?.let {
        {
            it.work()
            println(it.age)
        }
    }

    // =>转换简写  apply 直接返回当前的对象，可以直接调用对象的属性
    val apply = person?.apply {
        work()
        println("applay  $age")
    }

    // 内部调用本身
    person?.run {
        work()
    }

    person?.also {
        person ->
        person.work()
    }


    var withP = findPerson()
    if (withP == null){
        withP = Person("大南",12)
    }
    with(withP){
        println(name)
    }


    val br = BufferedReader(FileReader("hello.txt"))
    with(br){
        var line :String ?
        while (true){
            line =readLine()?:break
            println(line)
        }
        close()
    }

    // => 转换
    BufferedReader(FileReader("hello.txt")).use {
        var line :String ?
        while (true){
            line =it.readLine()?:break
            println("use $line")
        }
    }


    val brText = BufferedReader(FileReader("hello.txt")).readText()

    println(brText)



    var name1 :String = "zk"
    name1 = name1.let {
        return@let "wazing"
    }
    println("name $name1")
    name1.let {
        println("my name is $it")
    }

    val array = intArrayOf(1,3,4,5,6,6)
    val numbers = findDisappearNumbers(array)
    numbers.forEach{
        println(it)
    }


    var person1 = findPerson()

    if (person1 == null){
        person1 = Person("男",16);
    }



    person1.let {person ->
        println("内容是it,返回最后一行")
        person.age
        person.name
    }.apply {
        println("测试 $length")
    }

    person1.run {
        println("内容是this，返回最后一行")
        age
        name
    }.apply {
        println("run $length")
    }

    person1.also {
        println("内容是it,返回时自己本身")
    }.apply {
        name
        println(this.name)
    }
    with(person1){
        println("内容是this,返回最后一行")
        println(name)
        name
    }.apply {
        println("with $length")
    }



}

data class Person(val name: String, val age: Int){
    fun work(){
        println("$name is working")
    }
}

fun findPerson(): Person? {
    return null
}

var sum2 = { arg1: Int, arg2: Int -> arg1 + arg2 }

fun factorial(n: Int): Int {
    if (n == 0) return 1
    return (1..n).reduce { acc, i -> acc * i }
}


fun findDisappearNumbers(nums: IntArray): List<Int> {
    val ifAppear = BooleanArray(nums.size + 1)
    nums.forEach {
        println(it)
        ifAppear[it] = true }
    return ifAppear.mapIndexed {
            index, boolean ->
        println("index $index $boolean")
        if (boolean || index == 0) -1 else index
    }.filter { it != -1 }
}