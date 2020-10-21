package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/30.
 *
 * 主构造函数  class Header
 */
class Kp18Person(val name: String, var age: Int) {

    override fun toString(): String {
        return "Kp18Person(name='$name', age=$age)"
    }

}


/**
 * 只读属性用 val  不允许有setter
 * 可变属性用 var  有setter  和 getter
 *
 * 访问函数创建必须紧跟在属性的声明之后，在属性的访问函数里，不能直接调用属性，只能使用属性的变量名 field代替属性，
 * 若直接使用属性名，会出现递归，导致堆栈溢出
 */
class Kp18Person6(val name: String, var age: Int) {

    var isMarried: Boolean
        get() = this.name.isEmpty()


    var gender: String = "male"
        get() {
            println("this is a customized get()")
            return field
        }
        set(value) {
            println("this is a set")
            field = value
        }

    init {
        println("init Kp18Person5")
        isMarried = true

    }

    constructor(name: String, age: Int, gender: String) : this(name, age) {
        println("this is the first secondary constructor.")
        this.gender = gender

    }

    constructor(name: String, age: Int, gender: String, isMarried: Boolean) : this(name, age, gender) {
        println("this is the second secondary constructor.")
        this.isMarried = isMarried

    }
}


// 次构造函数，必须在第一行代码调用主构造函数,中不能出现 参数的声明
class Kp18Person5(val name: String, var age: Int) {

    var gender: String
    var isMarried: Boolean

    init {
        println("init Kp18Person5")
        gender = "male"
        isMarried = true

    }

    constructor(name: String, age: Int, gender: String) : this(name, age) {
        println("this is the first secondary constructor.")
        this.gender = gender

    }

    constructor(name: String, age: Int, gender: String, isMarried: Boolean) : this(name, age, gender) {
        println("this is the second secondary constructor.")
        this.isMarried = isMarried

    }
}


class Kp18Person4 {
    init {
        println(" init Kp18Person4")
    }
}

class Kp18Person3(val name: String, var age: Int, gender: String, iMarried: Boolean) {
    val gender: String

    // 初始化
    init {
        this.gender = gender
    }

    val inMarried: Boolean = iMarried
}

// 对参数属性没有定义类型，那就访问不到对应的数据类型
class Kp18Person1 constructor(name: String, age: Int)

class Kp18Person2 internal constructor(val name: String, var age: Int)