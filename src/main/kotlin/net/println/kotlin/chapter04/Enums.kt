package net.println.kotlin.chapter04

/**
 *
 * @author zhangkun
 * @time 2020/5/27 5:12 下午
 */
// kotlin 中唯一需要添加分号的地方
enum class LogLevel(val id: Int) {
    VERBOSE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), ARRERT(5);

    fun getTag(): String {
        return "$id,$name"
    }
}

fun main(args: Array<String>) {
    println(LogLevel.DEBUG.getTag())
    // 排序
    println(LogLevel.DEBUG.ordinal)
    LogLevel.values().map {
        println(it)
    }
    LogLevel.values().map(::println)

}