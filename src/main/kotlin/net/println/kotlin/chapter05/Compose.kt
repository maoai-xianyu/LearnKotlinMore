package net.println.kotlin.chapter05

/**
 *
 * @author zhangkun
 * @time 2020/6/2 11:54 上午
 * 复合函数  f(g(x)) m(x) = f(g(x))
 */

val add5 = { i: Int -> i + 5 }  // g(x)
val multiply = { i: Int -> i * 2 } // f(x)

fun main(args: Array<String>) {
    println(multiply(add5(5))) // === (5+5)*2

    val add5AndMultiply = add5 andThen multiply
    val add5CompposeMultiply = add5 compose multiply
    println(add5AndMultiply(5)) // m(x) = f(g(x))
    println(add5CompposeMultiply(5)) // m(x) = g(f(x))


}
// 5 -> P1   add5() 的返回值 P2    multiply --> function   扩展的是 Function1的方法
infix fun <P1, P2, R> Function1<P1, P2>.andThen(function: Function1<P2, R>): Function1<P1, R> {
    return fun(p1: P1): R {
        return function.invoke(this.invoke(p1))
    }
}

infix fun <P1, P2, R> Function1<P2, R>.compose(function: Function1<P1, P2>): Function1<P1, R> {
    return fun(p1: P1): R {
        return this.invoke(function.invoke(p1))
    }
}