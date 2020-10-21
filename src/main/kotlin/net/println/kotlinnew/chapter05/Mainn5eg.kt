package net.println.kotlinnew.chapter05

/**
 *
 * @author zhangkun
 * @time 2020/6/10 11:14 下午
 */


class Person(var age:Int,var name:String){
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as Person
        if (age != other.age) return false
        if (name != other.name) return false
        return true
    }
    override fun hashCode(): Int {
        var result = age
        result = 31 * result + name.hashCode()
        return result
    }
}

fun main(args: Array<String>) {
    val persons = HashSet<Person>()
    (0..5).forEach{
        persons += Person(20,"zk")
    }
    println(persons.size)
    // 不实现haskcode和 equels -> 6
    // 实现haskcode和 equels -> 1


    val personSet = HashSet<Person>()
    val person = Person(20,"丹娜")
    personSet += person
    println(personSet.size) //1
    person.age++
    personSet -= person // 移除不掉，发生了变化，在HashSet种移除不掉(对象的值变了)
    println(personSet.size)
    // 1
}