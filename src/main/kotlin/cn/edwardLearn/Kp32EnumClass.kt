package cn.edwardLearn

/**
 * 枚举类
 */

enum class DepartmentOne {
    HR, IT, SALES
}


enum class DepartmentTwo(val fullName: String, val numEmployees: Int) {
    HR("Human Resources", 8),
    IT("Information Technology", 15),
    SALES("Sales", 20);

}


enum class DepartmentThree(val fullName: String, val numEmployees: Int) {
    HR("Human Resources", 8) {
        override fun printSomething() {
            println("this is hr")
        }
    },
    IT("Information Technology", 15) {
        override fun printSomething() {
            println(getService())
        }

        fun getService() = "we are family"
    },
    SALES("Sales", 20) {
        override fun printSomething() {
            println("this is sales")
        }
    };

    fun getDepInfo() = "The $fullName department has $numEmployees employees"

    abstract fun printSomething()


    enum class OpenDay{
        Monday,Tuesday,Wednesday
    }
}


fun main(args: Array<String>) {
    println(DepartmentTwo.values().joinToString { it.name })
    println(DepartmentTwo.values().joinToString { it.fullName })
    println(DepartmentTwo.values().joinToString { it.ordinal.toString() })
    println(DepartmentThree.HR.getDepInfo())
    DepartmentThree.HR.printSomething()
    DepartmentThree.IT.printSomething()

    println(DepartmentThree.OpenDay.Monday)

}