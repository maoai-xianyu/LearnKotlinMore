package net.println.kotlin.chapter04

/**
 *
 * @author zhangkun
 * @time 2020/5/27 4:37 下午
 */

class OuterClass {
    val a = 10

    // 静态内部类
    class InnerClass {
    }

    // 非静态内部类 修饰 inner
    inner class InnerClassF {
        fun hello() {
            println(a)
            println(this@OuterClass.a)
        }
    }
}

interface ClickListener {
    fun onClick()
}

class BtnClick {
    var listener: ClickListener? = null
}

fun main(args: Array<String>) {
    val innerClass = OuterClass.InnerClass()
    val innerClassF = OuterClass().InnerClassF()

    // 内名内部类
    val click = BtnClick()
    click.listener = object : ClickListener{
        override fun onClick() {
        }
    }
}