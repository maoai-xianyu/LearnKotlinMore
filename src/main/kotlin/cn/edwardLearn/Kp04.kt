package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/24.
 */
fun main(args: Array<String>) {

    val person = Person("test", 12)
    val someOne: Any = person
    // as 不安全  安全的是  todo
    val personB: Person = someOne as Person

    println(personB)

    if (someOne is Person) {
        println("true")
        println(someOne.name)
    }

}