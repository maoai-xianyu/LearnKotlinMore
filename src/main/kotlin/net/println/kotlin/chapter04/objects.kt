package net.println.kotlin.chapter04

/**
 *
 * @author zhangkun
 * @time 2020/5/20 12:09 上午
 */


class DriverNew

interface OnExternalDriverMountListener{
    fun onMount(diver: DriverNew)
    fun onUnmount(diver: DriverNew)
}

object MusicPlayer:OnExternalDriverMountListener {
    val state: Int = 0

    fun plau(url: String) {

    }

    override fun onMount(diver: DriverNew) {
    }

    override fun onUnmount(diver: DriverNew) {
    }
}