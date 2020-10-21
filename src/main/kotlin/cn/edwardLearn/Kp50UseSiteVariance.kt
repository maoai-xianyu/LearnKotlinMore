package cn.edwardLearn

// kotlin  in  输入参数

fun main(args: Array<String>) {

    val cars1 = mutableListOf(CarTest(), CarTest())

    val cars2 = mutableListOf<CarTest>()

    val cars3: MutableList<CarTest> = mutableListOf()

    copyCarsTest(cars1, cars2)
    copyCarsTest(cars1, cars3)

    val ford1 = mutableListOf(FordTest(), FordTest(), FordTest())

    val ford2: MutableList<FordTest> = mutableListOf()

    copyCarsTest(ford1, ford2)


    val cars4: MutableList<CarTest> = mutableListOf(FordTest(), FordTest(), FordTest())

    copyCarsTest(ford1, cars2)


}


open class CarTest

class FordTest : CarTest()

fun <T> copyCarsTest(source: MutableList<T>, destination: MutableList<in T>) {
    source.forEach { destination.add(it) }
}


