package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/6/8.
 *
 * 伴生对象
 */

class Kp29CompanionObject {

    companion object {

        val test = "ssdsdsd"
        private val privateVar = 10

        fun accessPrivateVar() = "Accessing privateVar : ${privateVar}"
    }

    /*private val privateVar = 10

    fun asscessPrivateVar() = "Accessing privateVar : $privateVar"*/


    val oneString: String

    constructor(str: String) {
        oneString = str
    }

    constructor(str: String, lowerCase: Boolean) {

        if (lowerCase) {
            oneString = str.toLowerCase()
        } else {
            oneString = str.toUpperCase()
        }
    }

}


fun main(args: Array<String>) {
    // 不能直接调动，不是静态的
    //println(Kp29CompanionObject().accessPrivateVar())

    /**
     * companion object
     */
    println(Kp29CompanionObject.accessPrivateVar())
    println(Kp29CompanionObject.accessPrivateVar())

    val test = Kp29CompanionObject("this is a turn.", true)
    println(test.oneString)

    println(Config.FamousCourseState.FC_CHINA)
}