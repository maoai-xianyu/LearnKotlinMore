package net.println.kotlinnew.chapter08.eg.vmmbinding1

import java.util.concurrent.ConcurrentHashMap
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 * 基于泛型的model实例注入
 * 回顾属性代理
 * 掌握泛型的常见概念
 */

inline fun <reified T : AbsModel> modelOf(): ModelDelegate<T> {
    return ModelDelegate(T::class)
}

// T 是属性的类型 ReadOnlyProperty 只读
class ModelDelegate<T : AbsModel>(val kClass: KClass<T>) : ReadOnlyProperty<Any, T> {
    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return Models.run { kClass.get() }
    }
}

object Models {
    private val modelMap = ConcurrentHashMap<Class<out AbsModel>, AbsModel>()

    // 添加泛型约束 this 代表的是 KClass   this 是 class  this.java 是javaClass  this.java.kotlin 是kclass
    fun <T : AbsModel> KClass<T>.get(): T {
        return modelMap[this.java] as T
    }

    // Java
    fun <T : AbsModel> Class<T>.get(): T {
        return modelMap[this] as T
    }

    // register 是 AbsModel 的扩展方法，将类的实力放入map
    fun AbsModel.register() {
        modelMap[this.javaClass] = this
    }
}

abstract class AbsModel {
    init {
        Models.run {
            // 当创建 DatabaseModel 那么 this@AbsModel 就是 DatabaseModel
            this@AbsModel.register()
        }
    }
}

class DatabaseModel : AbsModel() {
    fun query(sql: String): Int = 0
}

class NetworkModel : AbsModel() {
    fun get(url: String): String = """{"code": 0}"""
}

// 每次获取的x都是一个变量
val x: Int
    get() {
        return Math.random().toInt()
    }

class MainViewModel {
//    val databaseModel by ModelDelegate<DatabaseModel>(DatabaseModel::class)
//    val networkModel by ModelDelegate<NetworkModel>(NetworkModel::class)
    // 泛型特化
    val databaseModel by modelOfOf<DatabaseModel>()
    val networkModel by modelOfOf<NetworkModel>()
}

// 泛型特化
inline fun <reified T : AbsModel> modelOfOf(): ModelDelegate<T> {
    return ModelDelegate(T::class)
}

fun initModels() {
    DatabaseModel()
    NetworkModel()
}

fun main() {
    initModels()
    val mainViewModel = MainViewModel()
    mainViewModel.databaseModel.query("select * from mysql.user").let(::println)
    mainViewModel.networkModel.get("https://www.imooc.com").let(::println)
}