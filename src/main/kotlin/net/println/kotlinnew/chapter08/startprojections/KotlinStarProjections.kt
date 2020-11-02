package net.println.kotlinnew.chapter08.startprojections

/**
 *
 * @author zhangkun
 * @time 2020/10/29 12:20 上午
 */

fun main() {
    //region fold
    val queryMap: QueryMap<*, *> = QueryMap<String, Int>()
    queryMap.getKey()  // 返回 String
    queryMap.getValue() // 返回 Int

    val f: Function<*, *> = Function<Number, Any>()
    //f.invoke() //逆变没有办法取下限  Nothing

    if (f is Function) {
        (f as Function<Number, Any>).invoke(1, Any())
    }

    maxOf(1, 3)

    HashMap<String, List<*>>()
    //endregion

    val hashMap: HashMap<*, *> = HashMap<String, Int>()
    //hashMap.get()

}


//region fold
class QueryMap<out K : CharSequence, out V : Any> {
    fun getKey(): K = TODO()
    fun getValue(): V = TODO()
}

fun <T : Comparable<T>> maxOf(a: T, b: T): T {
    return if (a > b) a else b
}

class Function<in P1, in P2> {
    fun invoke(p1: P1, p2: P2) = Unit
}
//endregion