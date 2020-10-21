package net.println.kotlinnew.chapter03


/**
 *
 * @author zhangkun
 * @time 2020/10/15 9:09 下午
 */

fun main(vararg args: String) {

    println(args.contentToString())

    val x: (Foo, String, Long) -> Any = Foo::bar
    val x1: Foo.(String, Long) -> Any = Foo::bar
    val x2: Function3<Foo, String, Long, Any> = Foo::bar

    val y: (Foo, String, Long) -> Any = x

    // 作为一个参数传入
    yy(x)

    val f: () -> Unit = ::foo

    val g: (Int) -> String = ::foo

    val h: (Foo, String, Long) -> Any = Foo::bar

    defaultParameter(y="hello")

    val (a,b,c) = multiReturnValues()
    println("Triple  $a $b $c")
}

// 参数是的类型是 (Foo,String,Long) -> Any
fun yy(p: (Foo, String, Long) -> Any) {
    p.invoke(Foo(),"hello",3L)
}


class Foo {
    fun bar(p0: String, p1: Long): Any {
        println("有receiver 的函数是方法 $p0 ----$p1")
        return "有receiver 的函数是方法  $p0 ----$p1"
    }
}

fun foo() {
    println("一等公民 函数，没有参数")
}

fun foo(p0: Int): String {
    println("一等公民 函数有参数 $p0")
    return "一等公民 函数有参数 $p0"
}


fun defaultParameter(x: Int = 5, y: String, z: Long = 0L) {
    println(" $x  -- $y   $z")
}


fun multiReturnValues(): Triple<Int, Long, Double> {
    return Triple(1, 3L, 4.0)
}


