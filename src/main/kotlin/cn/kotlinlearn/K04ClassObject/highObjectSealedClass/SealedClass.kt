package cn.kotlinlearn.K04ClassObject.highObjectSealedClass

/**
 * Created by zhangkun on 2017/6/5.
 *
 * 要定义一个密封类，只需在定义类名前加上 sealed 关键字
 *
 * 1、密封类是为 继承 设计的，是一个抽象类；
 * 2、密封类的子类是确定的，除了已经定义好的子类外，它不能再有其他子类
 *
 *
 * 因为密封类是一个抽象类，所以不能用 data 等非抽象类的修饰符来修饰它，也不用加 open 关键字。
 *
 * 密封类的子类，要么写在密封类内部，要么写在父类同一个文件里，不能出现在其他地方。但子类的子类可以出现在其他地方。
 *
 *
 * 密封类的使用与一般抽象类并无不同，也就是说不能使用密封类实例化对象，只能用它的子类实例化对象。
 *
 *
 * 密封类功能更多在于限制继承，起到划分子类的作用
 */
sealed class SealedClass(val name: String, val age: Int) {
    class SealedClassA(name: String, age: Int) : SealedClass(name, age)
    class SealedClassB(name: String, age: Int) : SealedClass(name, age)
}