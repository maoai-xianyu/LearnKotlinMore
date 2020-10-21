package cn.kotlinlearn.K02ClassConstructor.bean

/**
 * Created by zhangkun on 2017/6/2.
 *
 * 如果父类定义了主构造函数，子类就必须显式地调用父类的主构造函数，
 *
 * 1、不允许用 val 属性覆盖 var 属性。Kotlin 还允许用 var 属性覆盖 val 属性（只需给子类中的属性添加一个 setter 方法），但不允许用 val 属性覆盖 var 属性：
 */
class DogC(name: String) : DogP(name) {
    override var desc = ""
        set(value) {
            //field = if (value.isEmpty()) " " else value[0].toUpperCase() + value.substring(1)
            field = value + "狗宝宝"
        }
        get() = field
    override var age = 0
    override fun say() = "I am DogC named $name,$age years old"
}