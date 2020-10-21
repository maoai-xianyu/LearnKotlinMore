package cn.edwardLearn

// kotlin  out  返回参数

fun main(args: Array<String>) {

    val garden = Garden(listOf("Rose", "Daily", "Daffodil"))
    println("Flowers in this garden:${garden.flowers}")

    val flowers = listOf(1.1f, 2.3f, 5.5f, 8.8f)

    convertToInt(flowers)

    println("-----------------------")

//    val mutlFlowers = mutableListOf(1,3,5,8)
//
//    mutlConvertToInt(mutlFlowers)


    val oneRose = Rose()

    val roseGarden = Gardens(listOf(oneRose))

    println(roseGarden.containFlower(oneRose))

}


class Garden<T>(val flowers: List<T>)

fun convertToInt(list: List<Number>) {
    list.forEach { println("this number is ${it.toInt()}") }
}

fun mutlConvertToInt(list: MutableList<Number>) {
    list.forEach { println("this number is ${it.toInt()}") }
}

open class Flower

class Rose : Flower()

// class Gardens<T:Flower>(val flowers: List<T>)

class Gardens<out T : Flower>(val flowers: List<T>) {
    fun pickFlower(i: Int): T = flowers[i]

    fun containFlower(flower: @UnsafeVariance T): Boolean {
        return flower in flowers
    }
}

fun waterGarden(garden: Gardens<Flower>) {

}

fun maintainGarden(roseGarden: Gardens<Rose>) {
    waterGarden(roseGarden)
}