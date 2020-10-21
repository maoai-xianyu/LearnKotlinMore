package cn.kotlinlearn.K02ClassConstructor.bean


/**
 * Created by zhangkun on 2017/5/26.
 */
class Parent {

    var id: Long = 0
    var name: String = ""

    constructor()

    constructor(name: String) : this() {
        this.name = name
    }
}
