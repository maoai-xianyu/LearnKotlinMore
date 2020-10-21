package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/30.
 */
fun main(args: Array<String>) {

    visibleModifersFunOne()
    println("--------------------")

    classConstructorsFun()
}


private fun visibleModifersFunOne() {
    val personA = Kp18Person("jack", 12)
    println(" name ${personA.name} + age ${personA.age}")
    personA.age = 15
    println(" name ${personA.name} + age ${personA.age}")
    println(" personA $personA")

    val personB = Kp18Person1("sjjsjs", 33)
    //println(personB.name)

    val personC = Kp18Person2("sjjsjs", 33)
    println(personC.name)
}

fun classConstructorsFun() {

    val personA = Kp18Person4()
    println(personA)

    val personB = Kp18Person5("sss",33)
    println("male ${personB.gender} + name ${personB.name}")
    val personC = Kp18Person5("rose",88,"remale")
    println("male ${personC.gender} + name ${personC.name}")



}