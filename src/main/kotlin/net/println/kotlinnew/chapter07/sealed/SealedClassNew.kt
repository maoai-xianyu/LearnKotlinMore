package net.println.kotlinnew.chapter07.sealed

/**
 *
 * @author zhangkun
 * @time 2020/10/16 10:39 上午
 */
//region entity
data class Song(val name: String, val url: String, var position: Int)

data class ErrorInfo(val code: Int, val message: String)

object Songs {
    val StarSky =
        Song("Star Sky", "https://fakeurl.com/321144.mp3", 0)
}
//endregion

//region state 外部类不可以访问
sealed class SealedClassNew

object Idle : SealedClassNew()

class Playing(val song: Song) : SealedClassNew() {
    fun start() {
        println("playing")
    }

    fun stop() {
        println("stop")
    }
}

class Error(val error: ErrorInfo) : SealedClassNew() {
    fun recover() {
        println("recover")
    }
}
//endregion

class Player {
    var state: SealedClassNew =
        Idle

    fun play(song: Song) {
        this.state = when (val state = this.state) {
            Idle -> {
                Playing(song).also { playing -> playing.start() }
            }
            is Playing -> {
                state.stop()
                Playing(song).also { playing -> playing.start() }
            }
            is Error -> {
                state.recover()
                Playing(song).also { playing -> playing.start() }
            }
        }
    }
}

fun main(args: Array<String>) {
    val player = Player()
    player.play(Songs.StarSky)
}