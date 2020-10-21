package cn.edwardLearn

import cn.edwardLearn.Kp18Person
import cn.edwardLearn.Kp18Person6

/**
 * author:  zhangkun .
 * date:    on 2018/5/30.
 */
fun main(args: Array<String>) {
    val personA = Kp18Person("jack", 12)
    println(" name ${personA.name} + age ${personA.age}")

    personA.age = 33
    println(" name ${personA.name} + age ${personA.age}")


    val personB = Kp18Person6("TOM",14,"female")
    println(" name ${personB.name} + age ${personB.age} + gender ${personB.gender}")
}