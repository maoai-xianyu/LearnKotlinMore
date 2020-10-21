package cn.edwardLearn

import java.io.File

fun main(args: Array<String>) {

    val reader = File("/Users/boxfish/workspace/KotlinLearn/src/main/kotlin/cn/edwardLearn/Kp51testfile.txt").reader()

//    val readLines = reader.readLines()
//    readLines.forEach {
//        println(it)
//    }

    println("-----------")

//    val readText = reader.readText()
//    reader.close()
//    println("text $readText")

//    val use = reader.use { it.readText() }
//    println(use)


    reader.forEachLine { println(it) }

    println("-----------")

    val reader1 = File("/Users/boxfish/workspace/KotlinLearn/src/main/kotlin/cn/edwardLearn/Kp51testfile.txt").readText()
    println(reader1)

    println("----------- 获取文件")
    val reader3 = File("./src/main/kotlin/cn/edwardLearn/Kp51testfile.txt").readText()
    println(reader3)

    println("----------- 获取当前文件的目录下的文件")

    File(".").walkTopDown().forEach { println(it) }

    println("----------- 获取当前文件的目录下的文件 只获取 kt")

    File(".").walkTopDown()
            .filter { it.name.endsWith("kt") }
            .forEach { println(it) }

}