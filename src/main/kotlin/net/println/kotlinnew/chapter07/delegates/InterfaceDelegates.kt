package net.println.kotlinnew.chapter07.delegates

/**
 *
 * @author zhangkun
 * @time 2020/10/21 11:07 上午
 */

//region api
interface Api {
    fun a()
    fun b()
    fun c()
}

class ApiImpl : Api {
    override fun a() {}
    override fun b() {}
    override fun c() {}
}

class ApiWrapper(val api: Api) : Api by api {
    override fun c() {
        println("c is called.")
        api.c()
    }
}
//endregion