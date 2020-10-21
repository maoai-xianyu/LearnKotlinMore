package cn.kotlinlearn.K02ClassConstructor.bean

import java.io.Serializable

/**
 * Created by zhangkun on 2017/5/26.
 */

/**
 *不同的构造方法使用不同的参数列表，相互之间存在调用关系。Kotlin 中使用 次构造函数委托 的解决方法。
 *
 * 如果类已经有了一个主构造函数，那么所有的次构造函数都要直接或间接地委托给主构造函数。
 *
 * 次构造函数不能在参数列表中声明并初始化成员变量，这也是上面“name: String”前面为什么没有 val 的原因。
 */
class Student(val id: Long) : Serializable {

    var name: String = ""

    constructor(name: String) : this(name.hashCode().toLong()) {
        this.name = name
    }

    constructor(id: Long, name: String) : this(id) {
        this.name = name
    }

}