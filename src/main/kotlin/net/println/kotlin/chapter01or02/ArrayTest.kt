package net.println.kotlin.chapter01or02

/**
 *
 * @author zhangkun
 * @time 2020/4/3 12:01 下午
 */

class ArrayTest {
    override fun toString(): String {
        return super.toString()
    }
}

val FINAL_HELLO_WORLD: String = "Hello World"
var helloWord: String = FINAL_HELLO_WORLD
var nullablehelloWord: String? = helloWord
var charhelloWord: Array<Char> = arrayOf('h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd')
var charArrayhelloWord: CharArray = charArrayOf('h', 'e', 'l', 'l', 'o', 'w', 'o', 'r', 'l', 'd')

fun main(args: Array<String>) {

    println("charhelloWord ${charhelloWord.joinToString("")}")
    println("helloWord ${helloWord.slice(0 until helloWord.length - 1)}")
    println("helloWord ${ArrayTest::class.java.name}")

    println(" ----------------- ")
    val let = nullablehelloWord?.let {
        println(" let it $it")
    }

    println("let $let")

    val apply = nullablehelloWord.apply {
        println(" apply this $this")

    }
    println(" apply $apply")


    val run = nullablehelloWord?.run {
        println(" run this $this")
    }

    println(" run $run")

    val also = nullablehelloWord.also {
        println("also  it $it")

    }

    println(" also $also")


    val list = arrayListOf<String>()

    for (i in 0..100) {
        list.add(0, "item $i");
    }

    list.forEach {
        println("数据.. $it")
    }

    val c1 = IntArray(5) { it }
    println(c1.contentToString())


    val floatRange = 1f..2f
    println(floatRange.toString())
}