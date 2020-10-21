package net.println.kotlin.chapter01or02

/**
 *
 * @author zhangkun
 * @time 2020/8/7 8:44 上午
 */

val string :String = "HelloWorld"
val fromChars :String = String(charArrayOf('H', 'e', 'l', 'l', 'o', 'W', 'o', 'r', 'l', 'd'))
fun main(args: Array<String>) {
    println(string == fromChars) // 比较的是对象的值
    println(string === fromChars) // === 比较的是对象的引用值

    val sayhello :String = "hello \"temp\""
    println(sayhello)

    val salary:Int = 1000
    println("\$$salary")

    val rawString :String = """
        \t
        \n
        
    """.trimIndent()

    println(rawString)
}