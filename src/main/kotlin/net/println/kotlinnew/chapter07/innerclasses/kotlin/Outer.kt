package net.println.kotlinnew.chapter07.innerclasses.kotlin

class Outer {
    // 非静态内部类
    inner class Inner

    // 默认是静态内部类
    class StaticInner
}

object OuterObject {
    object StaticInnerObject
}

fun main() {
    val inner = Outer().Inner()
    val staticInner = Outer.StaticInner()
}