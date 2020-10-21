package cn.edwardLearn


fun main(args: Array<String>) {

    val someCondition: Boolean = 30 < 50
    val min = if (someCondition) {
        println(" choose 30 ")
        30
    } else {
        println(" choose 50 ")
        50
    }

    val min1 = if (someCondition) 30 else 50 //  == java 中的 三元操作符

    println("min = $min  min1 =  $min1")
}