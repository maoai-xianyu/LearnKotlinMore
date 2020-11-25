package net.println.kotlinnew.chapter07.delegates

// 约束
interface IGamePlayer {
    fun rank()
    fun upgrade()
}

// 被委托类，委托代打游戏
class RealGamePlayer(private val name: String) : IGamePlayer {
    override fun rank() {
        println("$name  进行了排名的比赛")
    }

    override fun upgrade() {
        println("$name  进行了排名的升级")
    }
}


// 委托类
class DelegateGamePlayer(private val pler: IGamePlayer) : IGamePlayer by pler

fun main(args: Array<String>) {
    val player = RealGamePlayer("zhangxxx")
    val dete = DelegateGamePlayer(player);
    dete.rank()
    dete.upgrade()
}
