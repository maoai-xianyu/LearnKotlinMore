package cn.kotlinlearn.K07Collection.collections

import java.util.*

/**
 * Created by zhangkun on 2017/6/7.
 */
fun main(args: Array<String>) {

    setofFun()

    println("-------------------")
    mutableSetOfFun()
    println("-------------------")
    hashSetOfFun()

    println("-------------------")

    linkedSetOfFun()

    println("-------------------")

    sortedSetOfFun()


    println("-------------------")

    treeSetOfFun()
}


fun setofFun() {
    val set = emptySet<String>()

    println(set?.size ?: "empty")

    val setSingle = Collections.singleton("empty")

    println(setSingle.any())
    println(setSingle.isEmpty())
    println(setSingle.iterator().hasNext())

    setSingle.forEach {
        println(it)
    }

    val setsof = setOf("mesds", "mesds", "asdasdas", "asdasdasd")

    setsof.forEach {
        println(it)
    }

}

fun mutableSetOfFun() {

    val s = mutableSetOf<String>()

    s.add("asdasdas")
    s.add("mesds")
    s.add("asdadas")
    s.add("aasdas")

    s.forEach {
        println(it)
    }
}

fun hashSetOfFun() {
    println("------------ hashSetOfFun ")

    val s = hashSetOf<String>()

    s.add("asdasdas")
    s.add("mesds")
    s.add("asdadas")
    s.add("aasdas")

    s.iterator().forEach {

        println(" 测试  $it")
    }

    s.forEach {
        println(it)
    }
}


fun linkedSetOfFun() {

    println("------------ linkedSetOfFun ")

    val s = linkedSetOf<String>()

    s.add("asdasdas")
    s.add("mesds")
    s.add("asdadas")
    s.add("basdas")

    s.forEach {
        println(it)
    }
}


fun sortedSetOfFun() {

    println("------------ sortedSetOfFun ")

    val s = sortedSetOf<String>()

    s.add("asdasdas")
    s.add("mesds")
    s.add("asdadas")
    s.add("basdas")

    s.forEach {
        println(it)
    }

    val ss = sortedSetOf(DESComparator())

    ss.add(Banana(2,2.3))
    ss.add(Banana(3,3.3))
    ss.add(Banana(4,1.3))
    ss.add(Banana(5,6.3))

    ss.forEach {
        println(it)
    }

}

fun treeSetOfFun() {
    val s = TreeSet<Apple>()

    s.add(Apple(2,2.3))
    s.add(Apple(3,3.3))
    s.add(Apple(4,1.3))
    s.add(Apple(5,6.3))


    s.forEach {
        println(it.toString())
    }

    val ss = TreeSet<Banana>(DESComparator())

    ss.add(Banana(2,2.3))
    ss.add(Banana(3,3.3))
    ss.add(Banana(4,1.3))
    ss.add(Banana(5,6.3))

    ss.forEach {
        println(it.toString())
    }
}


