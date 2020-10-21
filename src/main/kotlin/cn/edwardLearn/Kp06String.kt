package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/28.
 *
 * 原生字符串 是 """ """  可以包含换行 和任何其他任何字符而且没有转义，可以原原本本的打印字符串
 * trimMargin() 可以去聊字符串的前导空格，而且可以定义任意字符的边界前缀  默认是  "|"
 */
fun main(args: Array<String>) {


    val a = 5
    val b = 6

    val stringtext = """
        |ksdhfkjsdhfjh\b.
        |asdfsadfadfadfsdf\n.
        |sdfasdfasdfnkdsjf\t.
        |sdfsdfasdfkljlkjl\f.
        |sdfsadkfjskdjfjks\"
        |sdfsdfsdfsdfsdfsd\\
        |$a+$b = ${sum(a, b)}
    """.trimMargin()


    val stringtext1 = """
        *ksdhfkjsdhfjh\b.
        *asdfsadfadfadfsdf\n.
        *sdfasdfasdfnkdsjf\t.
        *sdfsdfasdfkljlkjl\f.
        *sdfsadkfjskdjfjks\"
        *sdfsdfsdfsdfsdfsd\\
    """.trimMargin("*")

    println(stringtext)
    println("----------------")
    println(stringtext1)
}