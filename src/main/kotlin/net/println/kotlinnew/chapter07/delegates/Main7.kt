package net.println.kotlinnew.chapter07.delegates

/**
 *
 * @author zhangkun
 * @time 2020/6/11 7:23 下午
 */

class SuperArray<E>(
    private val list: MutableList<E?> = ArrayList(),
    private val map: MutableMap<Any, E> = HashMap()
) : MutableList<E?> by list, MutableMap<Any, E> by map {

    override fun isEmpty() = list.isEmpty() && map.isEmpty()

    override val size: Int
        get() = list.size + map.size

    override fun clear() {
        list.clear()
        map.clear()
    }

    override operator fun set(index: Int, element: E?): E? {
        if (list.size <= index) {
            repeat(index - list.size + 1) {
                list.add(null)
            }
        }
        return list.set(index, element)
    }

    override fun toString(): String {
        return """List: [$list]; Map: [$map]"""
    }
}

fun main() {
    val superArray = SuperArray<String>()
    val superArray2 = SuperArray<String>()
    superArray += "Hello"
    superArray["Hello"] = "World"
    superArray2[superArray] = "World"

    superArray[1] = "world"
    superArray[4] = "!!!"

    println(superArray)
    println(superArray2)
}