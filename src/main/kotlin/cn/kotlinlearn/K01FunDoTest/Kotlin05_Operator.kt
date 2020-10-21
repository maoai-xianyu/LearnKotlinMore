package cn.kotlinlearn.K01FunDoTest

/**
 * author:  zhangkun .
 * date:    on 2017/9/5.
 */
fun main(args: Array<String>) {
    stringFunPlus()

    operatorFun();
}

/**
 * 所有重载了运算符的函数都要用 operator 关键字标记。
 * 比如，Kotlin 中规定 + 号应该重载为 plus() 函数，所有基础类型都重载这个函数，执行 a + b 实际就是执行 a.plus(b)，
 * 对于 Int.plus() 函数，它执行的就是加法，
 * 对于 String.plus() 函数，它执行的就是字符串连接。
 */
fun stringFunPlus() {
    val s = "hello"
    println(s.plus("world!"))
    println(s.plus(""))
}

/**
 * == 和 !=  []
 */
fun operatorFun() {


    val num1 = 1
    val num2 = 1
    println((num1 == num2))

    val a = " test1"
    val b = " test2"
    println("测试  " + (a?.equals(b) ?: (b == null)))
    println("测试  " + !(a?.equals(b) ?: (b == null)))


    val c = ""
    val d = " test2"
    println("测试  " + (c?.equals(d) ?: (d == null)))
    println("测试  " + !(c?.equals(d) ?: (d == null)))


    val e = ""
    val f = ""
    println("测试  " + (e?.equals(f) ?: (f == null)))
    println("测试  " + !(e?.equals(f) ?: (f == null)))


    val array = arrayOf("hello", "world")
    var get = array.get(1)
    println(get)
    array.set(1, "测试")
    get = array.get(1)
    println(get)

    //is 和 !is 这两个运算符相当于 Java 中的 instanceof 运算符，用于检查对象是否是某个类的实例。

    val str = "hello world"
    println(str !is String)

    for (s in array) {
        println(s)
    }

    for (i in 1..10) {
        println(i)
    }


}

fun commpareEqual(c: String?, d: String): String {

    return if (c != null) {
        if (c == d) {
            c
        } else {
            d
        }
    } else {
        d
    }
}

fun ssdsd(x: String?, y: String): String {
    return x ?: y
}

fun commpareEqual2(x: String?, y: String): String {
    return if (x != null) if (x == y) x else y else y
}


fun commpareEqual3(x: String?, y: String): Int {
    return x?.length ?: 1
}

