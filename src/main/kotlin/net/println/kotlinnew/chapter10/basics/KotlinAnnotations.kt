@file:JvmName("Hello")

package net.println.kotlinnew.chapter10.basics

@Retention(AnnotationRetention.RUNTIME) //运行时
@Target(AnnotationTarget.CLASS)// 类上注解
annotation class Api(val url: String)

@Target(AnnotationTarget.VALUE_PARAMETER)
annotation class Path(val name: String = "")

@Target(AnnotationTarget.FUNCTION)
annotation class Get(val name: String)

@Api("https://api.github.com")
interface GitHubApi {

    @Get("/users/{name}")
    fun getUser(@Path name: String): User
}

class User


fun helloHello(){

}