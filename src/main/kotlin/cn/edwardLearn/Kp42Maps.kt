package cn.edwardLearn

// Kotlin  maps

fun main(args: Array<String>) {


    val immutableMap = mapOf(1 to Cars("green", "toyota", 2016),
            2 to Cars("red", "wey", 2016),
            3 to Cars("black", "lin ke", 2016)
    )

    println(immutableMap.javaClass)
    println(immutableMap)


    val mmutableMap = mutableMapOf(1 to Cars("green", "toyota", 2016),
            2 to Cars("red", "wey", 2017),
            3 to Cars("black", "lin ke", 2016))
    mmutableMap.put(4, Cars("piple", "dazong", 2016))
    println(mmutableMap.javaClass)
    println(mmutableMap)


    val mmutableHashMap = hashMapOf(1 to Cars("green", "toyota", 2016),
            2 to Cars("red", "wey", 2017),
            3 to Cars("black", "lin ke", 2016))

    println(mmutableHashMap.javaClass)
    println(mmutableHashMap)

    println("---------------")

    val pair = Pair(10, "ten")
    val firstValue = pair.first
    val secondValue = pair.second

    println(firstValue)
    println(secondValue)

    println("---------------转    解构声明")
    val (firstValue1, secondValue1) = pair
    println(firstValue1)
    println(secondValue1)


    println("--------------- 解构声明")

    for ((entrykey, entryValue) in mmutableMap) {
        println("entrykey $entrykey  map to entryValue + $entryValue")
    }

    println("--------------- 解构声明 需要对象实现component1() 方法")

    val car = Cars("green", "toyota", 2016)

    val (color, model, year) = car

    println("color $color  model $model  year $year")

}

// data 有 component1()
//data class Cars(val color: String, val model: String, val year: Int)
class Cars(val color: String, val model: String, val year: Int){
    operator fun component1() = color
    operator fun component2() = model
    operator fun component3() = year
}