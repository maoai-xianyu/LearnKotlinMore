package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/24.
 */
fun main(args: Array<String>) {


    // kotlin 中会给java类，起别名，对某些类型起别名   Appendable


    val person = Person("jake", 1)

    val person1 = Person(name = "java", age = 25)

    println(" peron $person")
    println(" peron1 $person1")

    val people: People = setOf(person, person1)

    println(people)

    val p: Predicate<Person> = { it.age == 25 }
    println(people.filter(p))
    println(foo(p))


}


// 类型的别名,只是停留在源代码的层面上
typealias People = Set<Person>

typealias Predicate<T> = (T) -> Boolean

fun foo(p: Predicate<Person>) = p(Person("tom", age = 19))