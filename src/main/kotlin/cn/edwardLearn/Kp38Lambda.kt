package cn.edwardLearn

import java.math.BigDecimal

/**
 * kotlin  lambda
 *
 *
 */
fun main(args: Array<String>) {


    var num = 5

    run {
        num++
        println("This is a lambda")
    }

    println("-------------------")

    oneTopLevel()

    println("-------------------")

    run(::oneTopLevel)

    val employees = listOf(Employees("M01", "f01", 2011),
            Employees("M02", "f02", 2015),
            Employees("M03", "f03", 2010),
            Employees("M04", "f04", 2002)
    )


    println(employees.minBy { e -> e.startYear })


    listName(employees, num)



    println(employees.minBy(Employees::startYear))


    println(employees.minBy { it.startYear })
}

data class Employees(val firstName: String, val lastName: String, val startYear: Int)


fun listName(employees: List<Employees>, num: Int) {

    employees.forEach {
        println(it.firstName)
        println(num)
    }
}

fun oneTopLevel() = println("this is a top level function!")