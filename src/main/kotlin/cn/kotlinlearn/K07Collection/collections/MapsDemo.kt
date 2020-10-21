package cn.kotlinlearn.K07Collection.collections


/**
 * author:  zhangkun .
 * date:    on 2017/6/22.
 */
fun main(args: Array<String>) {
    pairFun()
    println(" --------------------")
    mapTest()
    println(" --------------------")
    mutablMapTest()
}

fun pairFun() {


    val p1: Pair<String, Int> = "hello" to 1

    println(" p1.first  " + p1.first)
    println(" p1.second  " + p1.second)
    println(" p1.first  " + p1.copy())


    val array = intArrayOf(1, 2, 3)

    val list = listOf(array)

    println("-----" + list)

    list.forEach { println(it) }


    val map = mapOf(1 to 2, 3 to 4)
    for ((key, value) in map) {
        println("$key -> $value")
    }

}

fun mapTest() {
    val map: Map<Int, Number> = mapOf(1 to 2.3, 2 to 4.6)
    val entries = map.entries

    entries.forEach {
        println("[" + it.key + "]" + it.value)

    }

    val iterator = entries.iterator()
    iterator.forEach {

        println("[" + it.key + "]" + it.value)
    }

    val containsKey = map.containsKey(2)

    println("containsKey$containsKey ")


}


fun mutablMapTest() {
    val map: MutableMap<Int, Number> = mutableMapOf()

    map[1] = 2
    map[3] = 5
    map[4] = 6

    map.putAll(mutableMapOf(1 to 2, 3 to 4))
    val entries = map.entries

    entries.forEach {
        println("[" + it.key + "]" + it.value)

    }

    val iterator = entries.iterator()
    iterator.forEach {

        println("[" + it.key + "]" + it.value)
    }

    val containsKey = map.containsKey(2)

    println("containsKey$containsKey ")


}

