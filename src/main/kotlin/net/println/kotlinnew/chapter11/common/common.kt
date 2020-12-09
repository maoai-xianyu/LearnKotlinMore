package net.println.kotlinnew.chapter11.common

/**
 *
 * @author zhangkun
 * @time 2020/12/9 9:04 上午
 */

fun showUser(user: User){
    println(user)
}

fun showError(t:Throwable){
    println(t.message)
    t.printStackTrace(System.out)
}