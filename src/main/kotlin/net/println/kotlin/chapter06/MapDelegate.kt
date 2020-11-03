package net.println.kotlin.chapter06

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @author zhangkun
 * @time 2020/6/2 4:17 下午
 * 定义代理，可以就实现ReadWriteProperty 接口或者复写操作符
 */
class MapDelegate1(val map: MutableMap<String, String>) : ReadWriteProperty<Any, String> {

    override fun getValue(thisRef: Any, property: KProperty<*>): String {
        return map[property.name] ?: ""
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        map[property.name] = value
    }
}


class MapDelegate(val map: MutableMap<String, String>) {

    operator fun getValue(thisRef: Any, property: KProperty<*>): String {
        return map[property.name] ?: ""
    }

    operator fun setValue(thisRef: Any, property: KProperty<*>, value: String) {
        map[property.name] = value
    }
}