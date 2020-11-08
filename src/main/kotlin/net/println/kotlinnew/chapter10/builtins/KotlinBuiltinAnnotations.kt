@file:JvmName("KotlinAnnotations") //文件雷鸣
@file:JvmMultifileClass // 可以重复的定义文件名字，会将两个文件中的所有方法合在一起
package net.println.kotlinnew.chapter10.builtins

import java.io.IOException

@Volatile
var volatileProperty: Int = 0

@Synchronized // 同步函数
fun synchronizedFunction(){

}

val lock = Any()
fun synchronizedBlock(){
    synchronized(lock) {

    }
}

@Throws(IOException::class) // 等价于java 的 throws IOException
fun throwException(){

}
