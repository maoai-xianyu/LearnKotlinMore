package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/6/14.
 */


interface OneInterfaceFun {
    fun oneFunction(num: Int): String
}


fun takeOneInterface(oneInterfaceFun: OneInterfaceFun) {
    println("I am in takesOneInterface function : ${oneInterfaceFun.oneFunction(15)}")
}


// 作为输入参数的object 以及后面的那一部分，就是 object expression ,在函数调用的时候
// 创建一个崭新的instance,这个instance在函数调用后，就会被丢弃。
// 也就是说，如果这个函数被调用了n次，就有n个instance,然后被丢弃

// object 可以用于给变量赋值
fun main(args: Array<String>) {

    var mutableVAr = 45

    takeOneInterface(object : OneInterfaceFun {
        override fun oneFunction(num: Int): String {
            mutableVAr++
            return "I am in onefunction of oneInterfaceFun:${num * 10}"

        }
    })

    println("mutableVAr $mutableVAr")

    val coordination = object {
        var x: Int = 5
        var y: Int = 9
    }

    println("coordination  : ${coordination.x} ,${coordination.y}")

}