package net.println.kotlin.chapter04

/**
 *
 * @author zhangkun
 * @time 2020/5/19 11:07 下午
 */

class House

class Flower


class CountYard {

    private val house: House = House()

    private val flower: Flower = Flower()
}


class ForbiddenCity {
    // 模块内可见
    internal val houses = arrayOf(House(), House())
    val flowers = arrayOf(Flower(), Flower())
}

fun main(args: Array<String>) {
    val countYard = CountYard()

    var forbiddenCity = ForbiddenCity()

    forbiddenCity.flowers
}