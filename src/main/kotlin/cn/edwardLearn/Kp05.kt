package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/24.
 *
 * 字符串模板
 */
fun main(args: Array<String>) {


    val person = Person("test", 12)

    println("person ${person.name} + age = ${person.age}")

    println("a + b = ${sum(10,20)}")

    val  a = 5
    val  b = 6

    println("$a + $b = ${sum(a,b)}")

    print(" this price is $$a")

}


fun sum(a: Int, b: Int) = a + b