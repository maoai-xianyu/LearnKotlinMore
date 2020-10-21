package cn.kotlinlearn.K09HighFunction

/**
 * author:  zhangkun .
 * date:    on 2018/3/26.
 */
fun main(array: Array<String>) {

    val a = 8
    val b = 9
    println(" test" + sum(a, b))
    println(" test" + sum1(a, b))
    println(" test" + sum2(a, b))
    println("------------------")
    println(" test" + sum3.invoke(a, b))
    println("------------------")
    println(" test" + sum4.invoke(a, b))
    println("------------------")
    testFun()
    println("------------------")
    closureFun()
    println("------------------")

}


// 匿名函数 定义了参数列表、返回值类型和函数体，
// 也就是说，它只描述这个函数能做什么，没有定义它叫什么
val sum: (Int, Int) -> Int = fun(a: Int, b: Int) = a + b


val sum1 = fun(num1: Int, num2: Int) = num1 + num2


val sum2 = { a: Int, b: Int -> a + b }


//Function 接口
val sum3 = { a: Int, b: Int -> a + b }

// 扩展函数 定义函数对象时，在参数列表类型前加上被扩展的类型的形式。
val sum4: Int.(Int) -> Int = fun Int.(other: Int) = this + other

// 定义和调用高阶函数的写法  必须用(参数列表类型) -> 返回值类型
fun testFun() {
    val array = arrayOf(1, 2, 3)
    val destination = mutableListOf<Int>()
    array.mapTo(destination, ::square)
    destination.forEach {
        println(" :: $it")
    }
    // 函数引用 的形式把它传入 mapTo() 函数内。这种方法适用于要执行的操作已有函数定义时。
    // 函数引用是什么？它的写法是在函数名前加上 :: ，用来表示函数对象，而不是调用这个函数

    //调用高阶函数的另一个方法是 使用匿名函数或 Lambda 表达式传入所需的参数。
    val destination1 = mutableListOf<Int>()
    array.mapTo(destination1, fun(a: Int) = a * a)
    destination1.forEach {
        println("  匿名 $it")
    }
    // 或者用 Lambda 表达式代替匿名函数：
    val destination2 = mutableListOf<Int>()
    array.mapTo(destination2, { a: Int -> a * a })

    destination2.forEach {
        println("  匿名 $it")
    }

    // 如果高阶函数的最后一个参数是 Lambda 表达式，可以把 Lambda 表达式写在括号外面：
    val destination3 = mutableListOf<Int>()
    array.mapTo(destination3) { a: Int -> a * a }
    destination3.forEach {
        println("  Lambda $it")
    }
    // 如果 Lambda 只有一个参数，而且能够推断出它的类型，就可以省略参数声明，只写函数体，在函数体中用 it 调用这个参数：
    val destination4 = mutableListOf<Int>()
    array.mapTo(destination4) { it * it }
    destination4.forEach {
        println("  Lambda 简写 $it")
    }

}

fun square(a: Int) = a * a


// 高阶函数和 Lambda 表达式：闭包和扩展函数对象
fun closureFun() {
    val array = intArrayOf(1, 4, 0, -1, -4, 9)
    val countPositive = array.countPositive()
    println(" 个数 $countPositive")
    val countPositive1 = array.countPositive2()
    println(" 个数 $countPositive1")

}


