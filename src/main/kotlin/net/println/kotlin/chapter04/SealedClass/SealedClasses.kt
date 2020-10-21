package net.println.kotlin.chapter04.SealedClass

/**
 *
 * @author zhangkun
 * @time 2020/5/27 5:28 下午
 */
// 密封类的使用，必须在同一个文件内或者内部类
sealed class PlayerCmd {
    class Play(val url: String, val position: Long = 0) : PlayerCmd()
    object Stop : PlayerCmd()
}

// 枚举 用于状态
enum class SealedClasses {
    IDLE, PAUSE, PALYING
}