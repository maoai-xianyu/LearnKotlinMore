package cn.kotlinlearn.K09HighFunction

/**
 * author:  zhangkun .
 * date:    on 2018/5/25.
 *
 *
 * 高阶函数  匹配
 *
 * all() 函数，它 在只有所有元素都符合转入函数时才返回 true，只要有一个不符合就返回 false
 * any() 函数，它是 只要有一个元素符合条件就返回 true，所有元素都不符合条件才会返回 false
 * 对于同一个条件 P 和同一个数据集合 A，A.all( P ) == A.any( !P ) 一定成立。
 * none() 函数是 all() 的否命题，也就是说 只有所有元素都不符合条件时才返回 true，只要有一个元素符合条件就返回 false：
 */

fun main(args: Array<String>) {
    val strings = arrayOf("qweqweqwe", "svrhk", "zxczxczx", "piukmne", "asdasdasd")
    val findWordsInSameRow = findWordsInSameRow(strings)
    findWordsInSameRow.forEach {
        println("数据是    $it")
    }

    println("--------------------")

    val findWordsInSameRow2 = findWordsInSameRow2(strings)
    findWordsInSameRow2.forEach {
        println("正则匹配 数据是    $it")
    }
}

fun findWordsInSameRow(words: Array<String>): Array<String> {

    val rows = arrayOf("qwertyuiop", "asdfghjkl", "zxcvbnm")
    return words.filter {
        val c = it[0]
        val lookingFor = rows.first { it.indexOf(c) != -1 }
        it.none { lookingFor.indexOf(it, ignoreCase = true) == -1 }
    }.toTypedArray()
}


fun findWordsInSameRow2(words: Array<String>) = words.filter {
    it.toLowerCase() matches Regex("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")
}.toTypedArray()