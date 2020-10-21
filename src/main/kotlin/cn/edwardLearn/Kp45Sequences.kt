package cn.edwardLearn

// Kotlin  Sequences  需要终结类型的操作符

fun main(args: Array<String>) {

    val nameList = listOf("Joe", "Mary", "John", "Smith", "Joanna")

    nameList.filter { println("filtering $it");it[0] == 'J' }
            .map { println("mapping $it"); it.toUpperCase() }
            .find { println("finding $it");it.endsWith('N') }


    println("-------------------")

    nameList.asSequence()
            .filter { println("filtering $it");it[0] == 'J' }  // 中间类型操作
            .map { println("mapping $it"); it.toUpperCase() }  // 中间类型操作
            .find { println("finding $it");it.endsWith('N') }  // 终结链式函数 终结类型操作

}

