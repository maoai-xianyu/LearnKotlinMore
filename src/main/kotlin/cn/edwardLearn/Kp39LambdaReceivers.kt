package cn.edwardLearn


// kotlin   with  instance
// apply

fun countTo50(): String {

    val numbers = StringBuilder()

    for (i in 1..49) {
        numbers.append(i)
        numbers.append(",")
    }
    numbers.append(50)
    return numbers.toString()
}


fun countTo50with(): String {
    val numbers = StringBuilder()

    return with(numbers) {
        for (i in 1..49) {
            numbers.append(i)
            numbers.append(",")
        }
        append(50)
        toString()
    }

}

// 表达式函数
fun countTo50withExpression(): String = with(StringBuilder()) {
    for (i in 1..49) {
        append(i)
        append(",")
    }
    append(50)
    toString()
}

// 需要定义返回值
fun countTo50ApplyExpression(): String = StringBuilder().apply {
    for (i in 1..49) {
        append(i)
        append(",")
    }
    append(50)
}.toString()


fun main(args: Array<String>) {

    println(::countTo50)
    println(countTo50())
    println("---------------------")

    println(countTo50with())

    println("---------------------")
    println(countTo50withExpression())
    println(::countTo50withExpression)

    println("---------------------")
    println(countTo50ApplyExpression())
    println("---------------------")

    val employees = listOf(Employees("M01", "f01", 2011),
            Employees("M02", "f02", 2015),
            Employees("M03", "f03", 2010),
            Employees("M04", "f04", 2002)
    )

    findByLastName(employees, "f04")
    findByLastName(employees, "f06")
    println("---------------------")
    findByLastNameOne(employees, "f04")
    findByLastNameOne(employees, "f06")
}


fun findByLastName(employees: List<Employees>, lastName: String) {
//    for (employee in employees) {
//        if (employee.lastName == lastName) {
//            println("yes, last name is $lastName")
//            return
//        }
//    }

    employees.forEach {
        if (it.lastName == lastName) {
            println("yes, last name is $lastName")
            return
        }
    }

    println("no. there is no last name")
}

fun findByLastNameOne(employees: List<Employees>, lastName: String) {
//    for (employee in employees) {
//        if (employee.lastName == lastName) {
//            println("yes, last name is $lastName")
//            return
//        }
//    }

    employees.forEach {
        if (it.lastName == lastName) {
            println("yes, last name is $lastName")
            return@forEach
        }
    }

    println("no. there is no last name")
}