package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/31.
 *
 *
 * 类的继承
 */

fun main(args: Array<String>) {

    val car = Car("长城")
    car.printModel()
    println("price ${car.sellPrice()}")

    val compactCar = CompactCar("吉利")
    compactCar.printModel()

}


abstract class Vehicle(val modeName: String) {
    open fun printModel() {
        println("The model name of this vehicle is $modeName")
    }

    abstract fun sellPrice(): Double
}


open class Car(modeName: String) : Vehicle(modeName) {
    override fun printModel() {
        println("The model name of this com.mao.cn.Car is $modeName")
    }

    override fun sellPrice(): Double = 2299.99

    // final  不能被继承
}

class CompactCar(modeName: String): Car(modeName){
    override fun printModel() {
        println("The model name of this compactCar is $modeName")
    }
}

