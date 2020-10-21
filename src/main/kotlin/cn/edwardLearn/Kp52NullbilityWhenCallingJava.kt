package cn.edwardLearn

fun main(args: Array<String>) {

    val kp52Car = Kp52Car("Test","yellow",1,"carTest","name")
    kp52Car.color = "green"
    //kp52Car.color = null
    println(kp52Car)

    var model = kp52Car.model

    //var model:String = kp52Car.model

    println(model.javaClass)

    model = null

    println(model)


    var nameTest:String? = kp52Car.name
    nameTest = null

    println(nameTest)

    // kotlin 语言和其他语言调用的时候
    var modelTest = kp52Car.test

    modelTest = null

    println(modelTest)

    //val color :Int = kp52Car.color

}