package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/6/8.
 *
 * 办事对象
 */

class Kp30CompanionObject private constructor(var oneString: String) {

    /*companion object Kp30CompanionObjectCompanion {
        private val privateVar = 10

        fun accessPrivateVar() = "Accessing privateVar : $privateVar"
        fun firstFactory(str: String) = Kp30CompanionObject(str)
        fun secondFactory(str: String, lowerCase: Boolean): Kp30CompanionObject {
            return if (lowerCase) {
                Kp30CompanionObject(str.toLowerCase())
            } else {
                Kp30CompanionObject(str.toUpperCase())
            }
        }

    }*/


    companion object Kp30CompanionObjectCompanion : MyInterFace {
        override fun create(str: String): Kp30CompanionObject = Kp30CompanionObject(str)

        private val privateVar = 10

        fun accessPrivateVar() = "Accessing privateVar : $privateVar"
        fun firstFactory(str: String) = Kp30CompanionObject(str)

        @JvmStatic
        fun secondFactory(str: String, lowerCase: Boolean): Kp30CompanionObject {
            return if (lowerCase) {
                Kp30CompanionObject(str.toLowerCase())
            } else {
                Kp30CompanionObject(str.toUpperCase())
            }
        }

    }

}

interface MyInterFace {
    fun create(str: String): Kp30CompanionObject
}


fun main(args: Array<String>) {

    /**
     * companion object
     */
    println(Kp30CompanionObject.Kp30CompanionObjectCompanion.accessPrivateVar())
    println(Kp30CompanionObject.accessPrivateVar())


    val kp30A = Kp30CompanionObject.firstFactory("this is a first!")
    val kp30B = Kp30CompanionObject.secondFactory("this is a second!", false)


    println(kp30A.oneString)
    println(kp30B.oneString)


    // 无法创建实体类
    //val one = Kp30CompanionObject("init ")

    val kp30C = Kp30CompanionObject.create(" this is a interface")
    println(kp30C.oneString)

}