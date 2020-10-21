package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/24.
 */
fun main(array: Array<String>) {

    val personA = Person("p1", 12)
    val personB = Person("p2", 35)
    val personC = Person("p1", 12)

    // 结构相等
    println(personA == personB)
    println(personA == personC)

    // 引用相等
    println(personA === personC)
    println(personA === personC)

    val personD = personA

    println(personA === personD)
    println(personA == personD)
    println(personA != personB)
    println(personA !== personC)
}