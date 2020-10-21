package net.println.kotlinnew.chapter06

/**
 *
 * @author zhangkun
 * @time 2020/6/11 4:57 下午
 */

fun main(args: Array<String>) {


    // 目前还是不可以的 ，可以添加支持
    /*submitRunable{
        println("hello")

    }*/

    // 编译不过
    /*submit6{

    }*/

    submit6(object :Invokable{
        override fun invoke() {
        }
    })

}

// 传入java类不过，不能用SAM
fun submitRunable(runnable: Runnable){
    runnable.run()
}

// 传入接口编译不过，不能用SAM
fun submit6(invoke:Invokable){
    invoke.invoke()
}

interface Invokable{
    fun invoke()
}