package net.println.kotlinnew.chapter08.variances

// 泛型类
class Controller<T> {
    fun turnOn(obj: T) {
        println("obj $obj")
    }

    fun turnOff(obj: T) {
        println("obj $obj")
    }
}

class TV
class Fan

//----

// 泛型函数
fun <T> turnOn(obj: T) {
    println("obj $obj")
}

fun <T> turnOff(obj: T) {
    println("obj $obj")
}

// 泛型的不变性(Invariant)
// 学生
open class Student(val name: String)

// 女学生
class FemaleStudent(name: String) : Student(name)

// 大学
class University<T>(val name: String) {
    val map: MutableMap<String, T> = mutableMapOf()
    fun get(): T {
        return map[name]!!
    }

    fun put(student: T) {
        map[this.name] = student
    }
}

// 泛型的协变(Covariant) out

open class Student1(val name: String)

// 女学生
class FemaleStudent1(name: String) : Student1(name)

// 大学
class University1<out T>(val name: String) {
    val map: MutableMap<String, @UnsafeVariance T> = mutableMapOf()
    fun get(): T {
        return map[name]!!
    }

    fun put(student: @UnsafeVariance T) {
        map[this.name] = student
    }
}

//泛型的逆变(Contravariant) in

open class Student2(val name: String)

// 女学生
class FemaleStudent2(name: String) : Student2(name)

// 大学
class University2<in T>(val name: String) {
    val map: MutableMap<String, @UnsafeVariance T> = mutableMapOf()
    fun get(): @UnsafeVariance T {
        return map[name]!!
    }

    fun put(student: T) {
        map[this.name] = student
    }
}

// 使用处型变
open class Student3(val name: String)

// 女学生
class FemaleStudent3(name: String) : Student3(name)

// 大学
class University3<T>(val name: String) {
    val map: MutableMap<String, T> = mutableMapOf()
    fun get(): T {
        return map[name]!!
    }

    fun put(student: T) {
        map[this.name] = student
    }
}

// 使用处 协变 取
fun uneSiteCovariant(universityOut: University3<out Student3>) {
    val fams: Student3 = universityOut.get()
    // put 有问题 报错 Require Nothing? found Student?
    val femaleStudent3: FemaleStudent3 = FemaleStudent3("zzzzz")
    // university.put(femaleStudent3)
}


// 使用处 逆变 放
fun uneSiteContravariant(universityOut: University3<in Student3>) {
    val femaleStudent3 = FemaleStudent3("zzzzz")
    universityOut.put(femaleStudent3)

    // get 有问题 报错 Require Nothing? found Student?
    //val fams: Student3 = universityOut.get()
}


fun main(args: Array<String>) {

    // 泛型类
    println("泛型类")
    val tvC = Controller<TV>()
    val tv = TV()
    tvC.turnOn(tv)
    tvC.turnOff(tv)

    val tvF = Controller<Fan>()
    val fan = Fan()
    tvF.turnOn(fan)
    tvF.turnOff(fan)

    println("泛型函数")
    // 泛型函数
    turnOff(tv)
    turnOn(tv)

    turnOff(fan)
    turnOn(fan)

    println("泛型的不变性")
    // 泛型的不变性(Invariant)
    lateinit var university: University<Student>
    university = University<Student>("中北大学")
    // 不可以给 University<FemaleStudent>("女子大学") 因为 University<Student> 和 University<FemaleStudent> 之前没有任何关系
    // 泛型的不变性
    // university = University<FemaleStudent>("女子大学")
    val student = Student("张楠")
    val femaleStudent = FemaleStudent("张李")
    university.put(student)
    university.put(femaleStudent)
    val student1 = university.get()
    println("student1  $student1")

    val fame = University<FemaleStudent>("女子大学")
    // 女子大学只能放 FemaleStudent 不能放 Student
    //fame.put(student)
    // 同时也是不能获取到 FemaleStudent 赋值给 Student
    //val get:Student = fame.get()
    fame.put(femaleStudent)
    //------
    println("泛型协变")
    val fameout: University1<Student1> = University1<FemaleStudent1>("女子大学")
    // 添加协变后  可以将 FemaleStudent1  赋值给  Student1 意思是 University1<FemaleStudent1> 就可以当作 University1<Student1> 的子类
    val fameout1: Student1 = fameout.get()
    //------
    println("泛型逆变")
    val sister: FemaleStudent2 = FemaleStudent2("zhangzhang")
    // 编译通过 University2<Student2> 是 University2<FemaleStudent2> 子类
    val university2: University2<FemaleStudent2> = University2<Student2>("普通大学")
    university2.put(sister)
}

