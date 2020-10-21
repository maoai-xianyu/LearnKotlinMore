package net.println.kotlin.chapter04

/**
 *
 * @author zhangkun
 * @time 2020/5/14 6:45 下午
 * 接口代理  by 关键之
 */

// 一般经理
class Manager : Driver, Writer {
    override fun driver() {
        println("经理开车")

    }

    override fun writer() {
        println("经理写作")

    }
}

class SeniorManager(val driver: Driver, val writer: Writer) : Driver, Writer {
    override fun driver() {
        driver.driver()
        println("经理司机 开车")

    }

    override fun writer() {
        writer.writer()
        println("经理秘书 开车")
    }
}

// 接口代理
class SuperSeniorManager(val driver: Driver, val writer: Writer) :
    Driver by driver, Writer by writer {
}

class CarDiver : Driver {
    override fun driver() {
        println("司机开车")
    }
}

class PPTWriter : Writer {
    override fun writer() {
        println("秘书写作")
    }
}

interface Driver {
    fun driver()
}

interface Writer {
    fun writer()
}


fun main(args: Array<String>) {
    val driver = CarDiver()
    val writer = PPTWriter()
    val manager = SuperSeniorManager(driver,writer)
    manager.driver()
    manager.writer()
}
