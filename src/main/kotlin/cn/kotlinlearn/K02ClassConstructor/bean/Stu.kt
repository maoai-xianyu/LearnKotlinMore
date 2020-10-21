package cn.kotlinlearn.K02ClassConstructor.bean

/**
 * Created by zhangkun on 2017/5/26.
 */
/**
 * 1、需要自定义 setter 或 getter 的属性，不能放在类头里定义，必须在类体内定义
 * 2、getter 是一个没有参数、返回类型与属性类型相同的函数。
 * 3、setter 的参数列表一般有一个与属性类型相同的参数，没有返回值
 */
class Stu(name: String) {
    // 自定义添加setter 和 getter 方法。 那么在调用的时候，需要设置值
    var name = name
        set(value) {
            field = if (value.isEmpty()) " " else value[0].toUpperCase() + value.substring(1)
            //field = value.capitalize()
        }

    // field 是表示 幕后字段 的关键字，它在使用时相当于 this.name，但是只能用在 setter 方法内
    /**
     * 需要注意一点，不能在 getter 里再调用本属性，
     * 因为 Kotlin 代码里所有对属性的访问都会被编译为 getter 方法，这样写就会出现无限迭代和 StackOverFlowError
     */
    val isValidName
        get() = !name.isNullOrBlank()
}
