package appium



class Devices {
    companion object {
        const val XIAOMI_MIX4 = "xiaomi9;c890a5ce;9"
        const val DEFAULT_DEVICE_INFO = XIAOMI_MIX4
    }
}


class ConfigSys(val key: String, val defVal: String) {

    companion object {

        /**
         * adb 环境
         */
        @JvmStatic
        val ADB_HOME by lazy {
            ConfigSys("adb_home", "adb").fromSystem()
        }

        /**
         * 驱动服务地址
         */
        @JvmStatic
        val DRIVER_SERVER = ConfigSys("driver_server", "http://127.0.0.1:4723/wd/hub")


        /**
         * 文件夹根路径
         */
        @JvmStatic
        val DIR_ROOT: String by lazy {
            ConfigSys("user.dir", "/KotlinLearnMore/").fromSystem()
        }

        /**
         * 截屏文件夹
         */
        @JvmStatic
        val DIR_SCREENSHOT by lazy {
            "$DIR_ROOT/screenshots"
        }

        /**
         * 日志文件夹
         */
        @JvmStatic
        val DIR_LOG by lazy {
            "$DIR_ROOT/logs"
        }

        /**
         * 运行抓取的设备信息；格式："设备名称:设备ID:安卓版本"
         */
        @JvmStatic
        val DEVICE_INFO by lazy {
            ConfigSys("device_info", Devices.DEFAULT_DEVICE_INFO).fromSystem().split(";")
        }

        /**
         * 滑动误差阈值，经测试，最小滑动距离为22个像素，小于这个阈值，滑动事件将解析为点击事件
         */
        const val SWIPE_ACCURACY = 23
    }
}

fun ConfigSys.fromSystem(): String = java.lang.System.getProperty(this.key, this.defVal)