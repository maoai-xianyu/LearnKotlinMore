package net.println.kotlin.chapter10.io

import java.io.BufferedReader
import java.io.File
import java.io.FileReader
import java.io.IOException

/**
 *
 * @author zhangkun
 * @time 2020/10/22 8:50 上午
 */

fun main(vararg args: String) {
    var bufferedReader: BufferedReader? = null
    try {
        bufferedReader = BufferedReader(FileReader("build.gradle"))
        var line: String?
        while (bufferedReader.readLine().also { line = it } != null) {
            println(line)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        try {
            bufferedReader?.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }
    println("简单写法")
    val buffer = BufferedReader(FileReader("build.gradle"))
    var line: String
    while (true) {
        line = buffer.readLine() ?: break
        println(line)
    }
    buffer.close()

    println("简单写法-----use")

    val bufferR = BufferedReader(FileReader("build.gradle"))
    bufferR.use {
        var line: String
        while (true) {
            line = it.readLine() ?: break
            println(line)
        }
    }

    println("简单写法----- readlines")
    File("build.gradle").readLines().forEach(::println)
}