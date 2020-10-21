package com.mao.cn.kotlinlearn.K07Collection.generics

/**
 * Created by zhangkun on 2017/6/7.
 *
 *
 * 从另一个角度看，对于一个 Collection<A>，我们从其中读取出一个对象，这个对象可以是 A 的子类型，也可以是 A 类型，这种特性叫 协变（Convariant）；
 * 而要向 Collection<A> 写入一个对象时，我们既可以写入一个 A 类型对象，也可以写入 A 的父类型，这种特性叫 逆协变（contravariance），协变和逆协变都是类型安全的。
 *
 * 只能保证读取数据时类型安全的对象叫做生产者，用 out T 标记；把那些只能保证写入数据安全时类型安全的对象叫做消费者，用 in T 标记。
 *
 * Kotlin 集合框架：Iterable、Iterator 和 Collection
 *
 * out T 等价于 ? extends T，in T 等价于 ? super T，此外还有 * 等价于 ?。
 *
 *
 */
interface Source<out T> {

    fun netxtT(): T
}