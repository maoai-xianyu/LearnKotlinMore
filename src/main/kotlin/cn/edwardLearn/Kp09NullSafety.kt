package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/29.
 *
 * ?.  if(str == null) null else str.toUpperCase
 */
fun main(args: Array<String>) {


    nullSafetyPartOne()
    println("-------------------------------")
    nullSafetyPartTwo()
    println("-------------------------------")
    nullSafetyPartThree()
}


/**
 * ？ 和 ?:
 */
fun nullSafetyPartOne() {
    val str: String? = null

    println(str?.toUpperCase())

    val stu = Stu("jack", 12)


    val streetName = stu.address?.street?.name
    println("街道名字 $streetName")

    println("-------------------------------")

    val str1 = if (str != null) {
        str
    } else {
        "this is default"
    }
    println("str1 $str1")
    // 转换
    val str2 = str ?: "this is default"
    println("str2 $str2")
}

/**
 * 安全类型转换操作符 as?
 *
 * 非空断言操作符 !! 这个必须保证数据不为空，否则npe
 *
 */

fun nullSafetyPartTwo() {


    val someThing: Any = arrayOf(1, 2, 3, 4)
    val str2 = someThing as? String
    println(str2)

    println("-------------------------------")
    val str: String? = "hello word"
    if (str == null) {
        throw Exception()
    } else {
        str.toUpperCase()
    }
    println(str)

    val strTemp: String? = null
    // 转换
    // 转换报错在当前行
    /* val str1: String = strTemp!!.toUpperCase()
     println(str1)*/

    // 报错发送在赋值的地方
    /*val str1: String = strTemp!!
    val str3 = str1.toUpperCase()
    println(str3)*/

}

/**
 * let funtion
 *
 * it
 */
fun nullSafetyPartThree() {

    val nullableString: String? = null
    val nonNullableString = "Hello world"

    println(nullableString == nonNullableString)


    val name: String? = "John"

    // printName(name) 报错 是因为 non-null 和 null 不是同一个类型
    // 方案一 printName(name!!)
    // 方案二 if (name != null) printName(name)
    // 方案三
    /*if(name != null){
        val copy = name
        printName(copy)
    }*/
    name?.let { printName(it) }

    val e = ClassE()
    e.printlMe()

}

fun printName(name: String) {
    println("Name is $name")
}