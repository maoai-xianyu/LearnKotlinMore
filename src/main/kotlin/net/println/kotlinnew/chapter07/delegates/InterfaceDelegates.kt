package net.println.kotlinnew.chapter07.delegates

/**
 *
 * @author zhangkun
 * @time 2020/10/21 11:07 上午
 *
 *  by 关键字表示委托或者代理，
 *  接口代理，不需要实现接口的所有的方法，如果需要实现，是对接口的方法的增强
 */

//region api
interface Api {
    fun a()
    fun b()
    fun c()
}

class ApiImpl : Api {
    override fun a() {
        println("this is function a")
    }
    override fun b() {
        println("this is function b")
    }
    override fun c() {
        println("this is function c")
    }
}

class ApiWrapper(val api: Api) : Api by api {
    override fun c() {
        println("c is called.")
        api.c()
    }
}
//endregion


fun main() {
    val api = ApiImpl()
    val apiW = ApiWrapper(api)
    apiW.c()
    apiW.a()
}