package net.println.kotlinnew.chapter07.delegates

import kotlin.properties.Delegates
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *
 * @author zhangkun
 * @time 2020/10/21 11:07 上午
 *
 * 属性代理 by lazy 延迟加载
 */
// 类委托
class Person(val name: String) {
    val firstName by lazy {
        name.split(" ")[0]
    }
    val lastName by lazy {
        name.split(" ")[1]
    }
}

class Foo {
    val x: Int by X()

    var y: Int by X()

    var yy: Int by Y()
}

/**
 * thisRef —— 必须与 属性所有者 类型（对于扩展属性——指被扩展的类型）相同或者是它的超类型；
 * property —— 必须是类型 KProperty<*>或其超类型。
 * value —— 必须与属性同类型或者是它的子类型
 */
class X {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        println("x thisRef 是持有个对象属性的实例对应的是 Foo $thisRef  property  $property")
        return 2
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, i: Int) {
        println("x property name  ${property.name}")
    }
}

// 复制和需改值
class Y : ReadWriteProperty<Any, Int> {
    val map = HashMap<String, Int>()

    override fun getValue(thisRef: Any, property: KProperty<*>): Int {
        println("Y thisRef 是持有个对象属性的实例对应的是 Foo $thisRef")
        val value = map[property.name]
        println("value $value  map $map")
        return value ?: 0
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: Int) {
        println("Y  property name 是 ${property.name} value $value")
        map[property.name] = value
    }
}
//--

// 属性委托  observable  by Delegates.observable 实现"观察者模式"的变量  观察一个属性的变化过程
class StateManager {
    var state: Int by Delegates.observable(0) { property, oldValue, newValue ->
        println("State changed from $oldValue -> $newValue")
    }
}

class User {
    // 为 name 这个变量添加观察者，每次 name 改变的时候，都会执行括号内的代码
    var name: String by Delegates.observable("<no name>") { prop, old, new ->
        println("name 改变了：$old -> $new")
    }
}

// vetoable 与 observable一样，可以观察属性值的变化，不同的是，vetoable可以通过处理器函数来决定属性值是否生效。
class UserVetoable {
    var userVetoable: Int by Delegates.vetoable(0) { property, oldValue, newValue ->
        // 如果新的值大于旧值，则生效
        newValue > oldValue
    }

}

// 3 属性存储在映射中
class UserMap(val map: Map<String, Any>) {
    val name: String by map
    val age: Int by map
}
//---


fun main() {
    // 属性代理 observable
    val stateManager = StateManager()
    stateManager.state = 3
    stateManager.state = 4
    val user = User()
    user.name = "first: Tom"
    user.name = "second: Jack"

    // 属性代理 vetoable
    val userVetoable = UserVetoable()
    userVetoable.userVetoable = 10
    println("userVetoable == ${userVetoable.userVetoable}")
    userVetoable.userVetoable = 5
    println("userVetoable == ${userVetoable.userVetoable}")
    userVetoable.userVetoable = 100
    println("userVetoable == ${userVetoable.userVetoable}")


    val userMap = UserMap(
        mapOf(
            "name" to "oook",
            "age" to 2
        )
    )
    println("${userMap.age} + ${userMap.name} ")
    //--

    // 属性代理 ReadWriteProperty / ReadOnlyProperty 和 operate getValue/ setValue
    val foo = Foo()
    println(foo.x)
    foo.yy = 5
    println(foo.yy)
}