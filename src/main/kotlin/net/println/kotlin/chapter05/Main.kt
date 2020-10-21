package net.println.kotlin.chapter05

/**
 *
 * @author zhangkun
 * @time 2020/5/27 5:42 下午
 * 扩展函数
 */

fun main(args: Array<String>) {
    val array = arrayOf("", "ss", "", "测试", "test", "xxxx")
    val hellworld = Hello::world
    // 包级函数
    array.forEach(::println)
    // 成员方法，有一个隐含的参数就是调用者本身
    // isNotEmpty 扩展方法一定有一个默认的第一个参数就是调用他的实例,也就是String 或者说是  CharSequence
    array.filter(String::isNotEmpty).forEach(::println)
    val pdfPrinter = PdfPrinter()
    array.forEach(pdfPrinter::println)
}

class PdfPrinter{
    fun println(any:Any){
        kotlin.io.println(any)
    }
}

class Hello {
    fun world() {
        println("Hello world")
    }
}