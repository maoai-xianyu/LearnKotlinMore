package net.println.kotlin.chapter04

import java.lang.IllegalArgumentException

/**
 *
 * @author zhangkun
 * @time 2020/5/14 10:00 上午
 */

interface InputDevice {
    fun input(event: Any)
}

interface USBInputDevice : InputDevice
interface BLEInputDevice : InputDevice


abstract class USBMouse(val name: String) : USBInputDevice, OpticalMouse {
    override fun input(event: Any) {
    }

    override fun toString(): String {
        return name
    }
}

interface OpticalMouse

class Computer {

    fun addUSBInputDevice(inputDevice: USBInputDevice) {
        println("add usb input device $inputDevice")
    }

    fun addBLEInputDevice(inputDevice: BLEInputDevice) {
        println("add BLE input device $inputDevice")
    }

    fun addInputDevice(inputDevice: InputDevice) {
        when (inputDevice) {
            is USBInputDevice -> {
                addUSBInputDevice(inputDevice)
            }
            is BLEInputDevice -> {
                addBLEInputDevice(inputDevice)
            }
            else -> {
                throw IllegalArgumentException("输入设备类型不支持")
            }
        }
    }
}


class LogitechMouse : USBMouse("罗技鼠标") {

}

fun main(args: Array<String>) {
    val computer = Computer()
    val mouse = LogitechMouse()
    computer.addInputDevice(mouse)
}