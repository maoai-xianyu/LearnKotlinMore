package net.println.kotlin.chapter04

import kotlin.reflect.KProperty

/**
 *
 * @author zhangkun
 * @time 2020/5/27 10:54 上午
 */
class Delegates {
    val hello by lazy {
        "hello"
    }

    val xx by X()
    var xy by X()
}

// 代理方式  -- 仿照 Lazy.kt 的 getValue 方法
class X {
    private var value: String? = null
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {

        println("getValue: $thisRef -> ${property.name}")
        return value ?: ""
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("setValue: $thisRef -> ${property.name} = $value")
        this.value = value
    }

}

fun main(args: Array<String>) {

    val delegates = Delegates()

    println(delegates.hello)
    println(delegates.xx)
    println(delegates.xy)
    delegates.xy = "text"
    println(delegates.xy)

}