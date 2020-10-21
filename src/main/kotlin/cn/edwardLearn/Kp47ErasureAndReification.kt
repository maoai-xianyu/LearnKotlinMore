package cn.edwardLearn

import java.math.BigDecimal

// Kotlin 是运行在jvm上的   * 通配符   inline function

fun main(args: Array<String>) {

    val stringList = listOf("Hello", "Good Bye")


    if (stringList is List<String>) {
        println("This list contain strings")
    }

    val strings: Any = listOf("str1", "str2")

    if (strings is List<*>) {
        println("This list contain List *")

        val strList = strings as List<String>

        println(strList[0].replace("str", "replace"))
    }


    val anyThing = listOf("hello", "jjjjj", 1, BigDecimal(2.3), "Good Morning", 10.8f, BigDecimal(3.4))

    val elementsOfType = getElementsOfType<BigDecimal>(anyThing)

    elementsOfType.forEach { println(it) }


}

// inline funtions
inline fun <reified T> getElementsOfType(list: List<Any>): List<T> {

    val newList: MutableList<T> = mutableListOf()
    list.forEach { if (it is T){
        newList.add(it)
    }}
    return newList
}