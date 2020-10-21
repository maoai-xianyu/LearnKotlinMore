package cn.edwardLearn

// kotlin  in  输入参数

fun main(args: Array<String>) {

    val flowerCareTest = object :FlowerCare<FlowerTest>{
        override fun prune(flowerTest: FlowerTest)= println("T'm pruning a ${flowerTest.name}!")
    }

    // 下面的写法要用很多种，用上面的代替

    val roseCare = object : FlowerCare<RoseTest> {
        override fun prune(flowerTest: RoseTest) = println("T'm pruning a rose!")
    }

    val roseGarden = GardenTest(listOf(RoseTest(), RoseTest()), flowerCareTest)

    roseGarden.tendFlower(0)

    val daffodil = object : FlowerCare<Daffodil> {
        override fun prune(flowerTest: Daffodil) = println("T'm pruning a daffodil!")
    }

    val daffodilGraden = GardenTest(listOf(Daffodil(), Daffodil(), Daffodil()), flowerCareTest)

    daffodilGraden.tendFlower(2)

}


open class FlowerTest(val name: String)

class RoseTest : FlowerTest("Rose")

class Daffodil : FlowerTest("Daffodil")

interface FlowerCare<in T> {
    fun prune(flowerTest: T)
}

class GardenTest<T : FlowerTest>(val flowerTests: List<T>, val flowerCare: FlowerCare<T>) {
    fun tendFlower(i: Int) {
        flowerCare.prune(flowerTests[i])
    }
}
