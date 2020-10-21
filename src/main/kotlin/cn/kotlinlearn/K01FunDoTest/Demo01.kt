package cn.kotlinlearn.K01FunDoTest

/**
 * Created by zhangkun on 2017/5/23.
 */



fun main(args: Array<String>) {

    var a = 1
    var s1 = "a is $a"

    a = 2

    val s2 = "${s1.replace("is", "was")}, but now is $a"
    println(s2)
    println(s2)
    //-----------------------

    printProduct("6", "7")
    printProduct("a", "7")
    printProduct("a", "b")

    //-----------------------

    fun printLength(obj: Any) {
        println("'$obj' string length is ${getStringLength(obj) ?: " .... err,not a string"} ")
    }

    printLength("Incomprehensibilities")
    printLength(1000)
    printLength(listOf(Any()))

    //-------------

    listFor()

    listFor01()

    //-----
    ranges()
    inRanges()

    //-----------

    println(addVararg(2, 5, 2, 4, 5, 5))

}


//------------------------------

fun parseInt(str: String): Int? {
    return str.toIntOrNull()
}

fun printProduct(str1: String, str2: String) {
    val x = parseInt(str1)
    val y = parseInt(str2)

    if (x != null && y != null) {
        println(x * y)
    } else {
        println(" either  '$str1' or '$str2' is not a number")
    }
}

//------------------------------

fun getStringLength(obj: Any): Int? {
    if (obj is String) {
        return obj.length
    }
    return null
}

fun getStringLength01(obj: Any): Int? {
    if (obj !is String) {
        return null
    }
    return obj.length
}


fun getStringLength02(obj: Any): Int? {
    if (obj is String && obj.length > 0) {
        return obj.length
    }
    return null
}

//----------------------------

fun listFor() {
    val items = listOf("apple", "banana", "kiwi")
    for (item in items) {
        println("数据是 " + item)
    }
}

fun listFor01() {
    val items = listOf("apple", "banana", "kiwi")

    for (index in items.indices) {
        println("数据是 " + items[index])
    }

    val itemTemp = mutableListOf<String>()
    itemTemp.add("text1")
    itemTemp.add("text2")
    itemTemp.add("text3")

    itemTemp.forEach { println(it) }
}


//----------------------------

fun ranges() {

    val x = 10
    val y = 9
    if (x in 1..y + 1) {
        println("fits in the ranges")
    }
}

//----------------------------- 遍历

fun inRanges() {
    val list = listOf("a", "b", "c")
    if (-1 !in 0..list.lastIndex) {
        println("-1 is out of range")
    }

    if (list.size !in list.indices) {
        println("list size is out of valid list indices range too" + list.indices)
    }
}

//------------------------ vararg 多个同一类型的参数

fun addVararg(a: Int, b: Int, vararg n: Int): Int {
    var sum = a + b
    for (i in n) {
        sum += i
    }

    return sum
}



