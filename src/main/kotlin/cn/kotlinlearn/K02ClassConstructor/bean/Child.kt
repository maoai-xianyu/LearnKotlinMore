package cn.kotlinlearn.K02ClassConstructor.bean

/**
 * Created by zhangkun on 2017/5/27.
 */

/**
 * 类外属性
 * 一是直接写在类外并初始化的包级属性
 * 二是使用 const val 定义的 编译期常量。
 *
 * 1、在类外定义的包级属性，会被编译为一个“文件类”的静态变量
 * 2、编译期常量使用 const val 定义在类外，它与包级属性有一定的相似之处。
 *    只能定义在类外或对象（Object）内；\
 *    只能使用 String 或原生类型（Int、Double 等）初始化；
 *    不能自定义 getter（直接调用，不需要 getter）
 *
 * 四lateinit 修饰符
 *
 */

class Child(val name: String){

    lateinit var hello :String
    fun initHello(){
        hello = "hello,my name is $name"
    }
}

val maxID = Int.MAX_VALUE


// 编译这个文件，实际上会形成两个类，一个是我们定义的 Person 类，另一个是“文件类” PersonKt
/*
public final class ChildKt {
    private static final int maxID = Integer.MAX_VALUE;
    public static final int getMaxID() {
        return maxID;
    }
}*/


const val minID = Int.MIN_VALUE
