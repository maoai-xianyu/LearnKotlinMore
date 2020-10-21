package cn.kotlinlearn.K01FunDoTest

/**
 * author:  zhangkun .
 * date:    on 2017/9/13.
 */
fun main(args: Array<String>) {
    breakFun()

    breakFunTurn()

    breakFunTurnBreak()

    breakFunTurnBreakForeach()
}

// Kotlin 中强化版的 标签：
//标签名@ 表达式  //标签名为合法的标识符，与变量名和函数名格式相同
//----------------- break   continue   return   loop 循环
//---- 注意 return 后面的写法，换行和不换行有特别大的差距
fun breakFun() {
    loop@ for (i in 1..10) {
        println("  i  is $i")
        for (j in 1..10) {
            if (i == 3) break@loop //终止 i 循环
        }
    }


    val ints = intArrayOf(1, 3, 3, 4)


    ints.forEach {
        if (it == 3) return println(" 不换行 it " + it)
    }
}

/**
 * 但是 return 只会跳出一个显式定义的函数，不会跳出 lambda 表达式，
 * 所以这里的 return 会直接跳出 main() 函数，结束进程，后面的 3 没有遍历到。
 */
fun breakFunTurn() {

    val ints = intArrayOf(1, 3, 3, 4)

    ints.forEach {
        if (it == 3) return
        println(" 换行it没有跳出 lamda " + it)
    }

}

/**
 * 如果我们想跳出 lambda 表达式，
 * 可以用标签标记这个 lambda 表达式，然后让 return 返回到这个标签处：
 */
fun breakFunTurnBreak() {
    val ints = intArrayOf(1, 3, 3, 4)

    ints.forEach lit@ {
        if (it == 3) return@lit
        println(" 换行it 跳出 lamda " + it)
    }
}

fun breakFunTurnBreakForeach() {
    val ints = intArrayOf(1, 3, 3, 4)

    ints.forEach {
        if (it == 3) return@forEach
        println(" forEach换行it " + it)
    }
}