package com.mao.cn.kotlinlearn.K07Collection.mutableCollection.mapListSet

/**
 * Created by zhangkun on 2017/6/7.
 */


fun main(args: Array<String>) {

    mapFun()

    println("-----------------------")


    listFun()

    println("-----------------------")
    mapOfFun()
}

fun mapFun() {

    val map: Map<Int, Number> = mapOf(1 to 2.3, 2 to 3.5)
    println("  map  ${map[0]}  map get ${map[0]}")
    println("  map  ${map[1]}  map get ${map[1]}")
    println(message = "  map  ${map[1]}  map get ${map.get(1)}")
    val entries = map.entries

    for ((key, value) in entries) {
        println(" key $key")
        println(" value  $value")
    }

    entries.forEach {
        println(" key " + it.key)
        println(" value" + it.value)
    }

    map.map { println(it) }

}


//---------------------
fun listFun() {

    val list: List<String> = listOf("text", "text2", "text4")

    list.forEach { println(it) }

}

fun mapOfFun() {
    val map1: Pair<Int, String> = 1 to "hello"
    val map2: Pair<Int, String> = 2 to "world"
    val map3 = map1 to "world"

    val map: Map<Int, String> = mapOf(map1, map2)

    val entries = map.entries
    entries.forEach { println("" + it.key + " " + it.value) }
    for ((key, value) in entries) {
        println("entries  key $key value $value")
    }

    val minus = map.minus(2)
    val entries1 = minus.entries
    for ((key, value) in entries1) {
        println("entries1  key $key value $value")
    }


    println(" map3 ${map3.first}")
    println(" map3 ${map3.second}")
    println(" map3 ${map3.component1()}")
    println(" map3 ${map3.component2()}")
    println(" map3 ${map3.copy()}")


    println("----------------")
    val arr = arrayOf(1 to "hello", 2 to "world", Pair(4, "BEATS"))


    arr.forEach {

        println(" it $it")

    }
    val toMap = arr.toMap()
    toMap.forEach {
        println("" + it.key + "" + it.value)
    }

    toMap.forEach(::println)
}