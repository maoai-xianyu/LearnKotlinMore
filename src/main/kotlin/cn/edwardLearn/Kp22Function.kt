package cn.edwardLearn


/**
 * author:  zhangkun .
 * date:    on 2018/5/30.
 */
fun main(args: Array<String>) {

    println(sum(3, 5, "this is result = "))
    println(sum(3, 5))
    println(sum(a = 3, b = 5))
    println(sum(a = 3, lazy = "his is result =", b = 5))


    println("--------------------------")
    val student1 = Student("Tom1", 1)
    val student2 = Student("Tom2", 2)
    val student3 = Student("Tom3", 3)

    // 使用明明参数
    printNames("list name str1", student1, student2, student3, str = "list name")

    println("--------------------------")
    val students = arrayOf(student1, student3, student3)

    // 类型 不匹配  ---> 引入伸展操作符概念 *  解刨一个集合
    printNames("list name str1", *students, str = "list name")
    println("--------------------------")

    val student4 = Student("Tom4", 3)
    val student5 = Student("Tom5", 3)

    val studentsB = arrayOf(student4, student5)

    println(" students $students")
    println(" studentsB $studentsB")

    // *
    val studentMany = arrayOf(*students, *studentsB, student1)
    for (student in studentMany) {
        println(" studentMany $student")
    }
    println("--------------------------")

    printNames(*studentMany as Array<out Student>)
}


/**
 *  * 局部函数  必须写在调用函数之前，且
 */
fun printNames(vararg students: Student) {

    val str = "this student is called"
    fun localFun(stu: Student) {
        println("$str  ${stu.name}")
    }

    for (student in students) {
        localFun(student)
    }
}

/**
 * 一个function 中只能有一个vararg 参数
 *
 */
fun printNames(str1: String = "default str1", vararg students: Student, str: String = "default str") {
    println("str1 +$str1")
    println(str)
    fun localFun(stu: Student) {
        println(stu.name)
    }

    for (student in students) {
        localFun(student)
    }
}


fun sum(a: Int, b: Int, lazy: String = "result = "): String {
    return "$lazy ${a + b}"
}

fun sum1(a: Int, b: Int, lazy: String) = "$lazy ${a + b}"


data class Student(val name: String, var roomNo: Int, var grade: Int = 12) {
    fun printGrade() {
        println("Grade $grade")
    }
}