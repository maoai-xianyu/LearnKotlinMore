package cn.kotlinlearn.K06nothingUnit

/**
 * Created by zhangkun on 2017/6/7.
 * Unit 是一个真正的类，继承自 Any 类，只有一个值，也就是所谓的“单例”（目的在于函数返回 Unit 时避免分配内存）
 *
 * 正因为 Unit 是一个普通的对象（这里指用 object 关键字定义的单例类型），
 * 所以可以调用它的 toString() 方法：结果一定是 "Kotlin.Unit"
 *
 * Nothing 是一个 空类型（uninhabited type），也就是说，程序运行时不会出现任何一个 Nothing 类型对象
 *
 *
 */

fun main(args: Array<String>) {


    val nothing = doNothing()

    println(nothing.toString())
    fail()
    failFun()

}

//------------------Unit
fun doNothing(): Unit {
    println(" Unit  ")
}


//------------------------nothing
// othing 还有一个作用：如果上一行代码返回了 null，就可以保证下一行代码不会被执行到，不必额外再检查一次返回值了
fun fail() {
    throw RuntimeException("something went wrong ")
}

fun failFun(): Nothing {
    throw RuntimeException("something went wrong ")
}