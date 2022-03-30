package kwai

import io.appium.java_client.android.AndroidDriver


fun AndroidDriver<*>.adbStartActivityByDeeplink(url: String) {
    println("启动Activity，command：adb shell am start -a android.intent.action.VIEW -d '$url'")
    executeScript(
        MOBILE_COMMAND_SHELL,
        mapOf("command" to "am start -a android.intent.action.VIEW -d \"$url\"")
    )
}