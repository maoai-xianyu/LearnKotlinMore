package net.println.kotlin.chapter10.box.kotlin

import net.println.kotlin.chapter10.box.java.AbsBox
import net.println.kotlin.chapter10.box.java.BoxIf2

/**
 *
 * @author zhangkun
 * @time 2020/10/22 12:18 下午
 */

class BoxImpl3 : AbsBox() {
    override val size: Int
        get() = TODO("Not yet implemented")

    override fun containsKey(key: Int?): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsValue(value: String?): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override val entries: MutableSet<MutableMap.MutableEntry<Int, String>>
        get() = TODO("Not yet implemented")
    override val keys: MutableSet<Int>
        get() = TODO("Not yet implemented")
    override val values: MutableCollection<String>
        get() = TODO("Not yet implemented")

    override fun clear() {
        TODO("Not yet implemented")
    }

    override fun put(key: Int?, value: String?): String? {
        TODO("Not yet implemented")
    }

    override fun putAll(from: Map<out Int, String>) {
        TODO("Not yet implemented")
    }

    override fun remove(key: Int?): String? {
        TODO("Not yet implemented")
    }
}