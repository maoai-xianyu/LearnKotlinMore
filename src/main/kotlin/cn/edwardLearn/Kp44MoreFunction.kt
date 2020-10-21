package cn.edwardLearn

// Kotlin  more function

fun main(args: Array<String>) {

    val setInts = setOf(10, 9, 15, 8, 19, 2, 42, 1, 56, -33)
    println("-------------------集合中的奇数")
    println(setInts.filter { it % 2 != 0 })
    println(setInts)


    val mutableCars = mutableMapOf(1 to CarsCore("green", "toyota", 2014),
            2 to CarsCore("red", "wey", 2017),
            3 to CarsCore("black", "lin ke", 2018),
            4 to CarsCore("sliver", "dazong", 2017),
            5 to CarsCore("yellow", "lin ke", 2016))


    println(mutableCars.filter { it.value.color == "red" })
    println(mutableCars)

    // 给元素重新赋值
    val newSet = setInts.map { it + 100 }

    println(newSet)

    println("-------------------")
    val mutableList = mutableListOf<Int>()
    println(setInts.forEach { mutableList.add(it + 10) })
    println(mutableList)

    println("-------------------")


    println(mutableCars.all { it.value.year >= 2015 })

    println(mutableCars.any { it.value.year >= 2015 })

    println(mutableCars.count { it.value.year >= 2015 })

    // map 没有find function
    val cars = mutableCars.values
    println(cars.find { it.year >= 2015 })

    println(mutableCars.map { it.value }.find { it.year >= 2016 })
    println(mutableCars.toSortedMap())

    // 分组
    println(cars.groupBy { it.color })

    println(cars.sortedBy { it.year })

}



// data 有 component1()
data class CarsCore(val color: String, val model: String, val year: Int)