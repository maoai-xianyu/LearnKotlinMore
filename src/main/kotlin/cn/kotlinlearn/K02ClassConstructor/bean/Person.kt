package cn.kotlinlearn.K02ClassConstructor.bean

/**
 * Created by zhangkun on 2017/5/26.
 */

/**
 * 如果主构造函数没有任何修饰符，则可以去掉 constructor 关键字
 * 如果想使用在主构造函数前使用修饰符，那么这个 constructor 就不能省了：
 */
//class Person private constructor(val id: Long, val name: String = "", val age: Int = 0)

/**
 * 如果没有外部传入的参数，就使用默认值。
 * 参数列表中定义了三个参数，都使用 val 关键字修饰，说明要使用它们创建成员变量并初始化；
 * name 和 age 参数后面都使用 = 默认值 的方法声明了它们的默认值，在调用主构造函数的时候，如果不传入参数，就使用指定的默认值。
 */
class Person(val id: Long, val name: String = "", val age: Int = 0)