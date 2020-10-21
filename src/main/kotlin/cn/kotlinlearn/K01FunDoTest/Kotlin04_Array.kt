package cn.kotlinlearn.K01FunDoTest

import java.util.*

/**
 * author:  zhangkun .
 * date:    on 2017/9/5.
 */
fun main(args: Array<String>) {

    arrayCreateKnow()

    arrayCreateNull()

    arrayCreateArrar()

    arrayNull()
}


//1、创建已知所有元素的数组：
fun arrayCreateKnow() {
    val a = arrayOf("hello", "world!")
    for (s in a) {
        print(s + "")
    }
    println("-----------")
    a.map {
        println(it+" map")
    }

    //如果我们想像 Java 中那样创建一个长度指定，每个值都是 null 的数组，就要用 kotlin.arrayOfNulls() 函数

    val nullArray: Array<String?> = arrayOfNulls(2)
    nullArray[0] = "hello"
    nullArray[1] = "world"
    println("nullArray ----------")
    for (s in nullArray) {
        print(s + "")
    }
}

//2、创建一个空数组
fun arrayCreateNull() {
    //因为 emptyArray() 函数需要转换为特定的数组类型，所以定义变量需要指定数组类型，否则出现编译错误
    val emptyArray1: Array<String?> = emptyArray()
    //也可以写成 val emptyArray2: Array<String?> = arrayOfNulls(0)，这里是类型推断
    val emptyArray2 = arrayOfNulls<String?>(0)
    println(Arrays.equals(emptyArray1, emptyArray2)) // 输出 true
}

//3、创建基本类型数
//Kotlin 对于基本类型数组有特殊的优化，建议在涉及到基本类型的数组时使用下面列出的类，而不使用 Array 类。
fun arrayCreateArrar() {
    val intArray = intArrayOf(1, 2, 3, 4)
    val arrayOfInt = arrayOf(1, 2, 3, 4)

    for (i in intArray) {
        print(" $i")
    }

    println("arrayOfInt ")
    for (i in arrayOfInt) {
        print(" $i")
    }

    //IntArray 类并不是 Array 类的子类，所以上面两个数组并不是相同的对象

    println("------------------ ")

}

// 遍历数组
fun arrayNull() {
    val emptyArray1: Array<String?> = emptyArray()
    val emptyArray2: Array<String?> = arrayOfNulls(0)
    println(Arrays.equals(emptyArray1, emptyArray2))


    val emptyArray3: Array<String?> = arrayOf("test2", "test2")

    println(emptyArray3.iterator())


    val squares = Array(5, { it -> (it + 1) * (it + 1) })

    for (square in squares) {
        print("  square $square")
    }

    squares.forEach { i: Int -> println("  测试  " + i) }

    // it 代表当前引用的对象
    squares.forEach { print(" "+it) }

}


