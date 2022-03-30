package appium

import appium.ConfigSys.Companion.DIR_SCREENSHOT
import io.appium.java_client.MultiTouchAction
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.android.AndroidTouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.OutputType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.io.File
import java.net.MalformedURLException
import java.net.URL
import java.text.SimpleDateFormat
import java.time.Duration
import java.util.*
import java.util.concurrent.TimeUnit

class MultiUnitKt {

    // 使用百度地图

    @BeforeTest
    @Throws(MalformedURLException::class)
    fun setUp() {
        // 1. 创建配置对象
        val desiredCapabilities = DesiredCapabilities()
        /*
         2. 添加配置
         deviceName 可以找到我们的测试设备
        */desiredCapabilities.setCapability("deviceName", "c890a5ce")
        // platformName 测试平台 Android or iOS
        desiredCapabilities.setCapability("platformName", "Android")
        // uiautomator2 解决输入框输入不了数据  但是目前是可以的
        desiredCapabilities.setCapability("automationName", "uiautomator2")
        // noReset 每次进入应用，不清除应用数据 true 是不清除 默认是 false 和  Thread.sleep(10000) 配合，需要 @Test(enabled = false)
        desiredCapabilities.setCapability("noReset", true)
        // appPackage 找到要测试的app  百度
        desiredCapabilities.setCapability("appPackage", "com.baidu.BaiduMap")
        // appActivity 测试启动app入口
        desiredCapabilities.setCapability("appActivity", "com.baidu.baidumaps.WelcomeScreen")

        // 3. 创建驱动
        // 传入两个参数
        // 第一个参数：appium通讯地址
        // 第二个参数：配置对象
        androidDriver = AndroidDriver(
            URL("http://127.0.0.1:4723/wd/hub"),
            desiredCapabilities
        )
        // 30s 隐式等待
        androidDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)
    }


    @Test
    fun testApi() {

        Thread.sleep(5000)

        println(" 百度地图 dom ${androidDriver.pageSource}")

        // 会报安全问题 java.lang.SecurityException: Permission Denial:
        /*val activity = Activity("com.baidu.BaiduMap", "com.baidu.sapi2.activity.LoginActivity")
        androidDriver.startActivity(activity)*/

        //跳转驾考宝典
        /*val activity = Activity("com.handsgo.jiakao.android", "com.handsgo.jiakao.android.splash.Login")
        androidDriver.startActivity(activity)*/


        println(" -------------------\n")

        //println(" 驾考 dom ${androidDriver.pageSource}")
        println(" 当前 activity dom ${androidDriver.currentActivity()}")
        println(" 当前 activity dom ${androidDriver.isAppInstalled("com.handsgo.jiakao.android")}")


       /* val screenshotAs = androidDriver.getScreenshotAs(OutputType.FILE)
        FileUtils.copyFile(screenshotAs, File("../../../../file/test.png"))*/

        val now = SimpleDateFormat("yyyy-MM-dd_HH:mm:ss")
        val property = System.getProperty("user.dir", "/KotlinLearnMore/")
        androidDriver.getScreenshotAs(OutputType.FILE).copyTo(
            File("${property}/screenshots", "${now.format(Date(System.currentTimeMillis()))}.png")
        )
    }


    @Test(enabled = false)
    fun testBaiduMapToZoom() {

        val findElementByXPath =
            androidDriver.findElementByXPath("//android.widget.ImageView[@content-desc=\"上拉查看更多功能\"]")
        val location = findElementByXPath.location

        val touchAction = AndroidTouchAction(androidDriver)
        val optionStart = PointOption.point(location.x, location.y)
        val optionEnd = PointOption.point(location.x, location.y + 500)
        // 把原始时间转换成 WaitOptions 类型
        val waitOptions = WaitOptions.waitOptions(Duration.ofSeconds(4))
        touchAction.press(optionStart)
            .waitAction(waitOptions)
            .moveTo(optionEnd)
            .release()
            .perform()

        val big = androidDriver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"放大地图\"]")
        big.click()

        val small = androidDriver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"缩小地图\"]")
        small.click()


        // 1. 实例化  MultiTouchAction  对象
        val multiTouchAction = MultiTouchAction(androidDriver)
        val touchAction1 = AndroidTouchAction(androidDriver)
        val touchAction2 = AndroidTouchAction(androidDriver)

        // 2. 得到屏幕的高度

        val y = androidDriver.manage().window().size.getHeight()
        val x = androidDriver.manage().window().size.getWidth()

        println(" y $y  --  x  $x")

        // 3.  第一个手指   B <-> A  第二个手指 C <--> D
        // 确定 B  和  A 的位置
        touchAction1.press(PointOption.point(x * 4 / 10, y * 4 / 10))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
            .moveTo(PointOption.point(x * 2 / 10, y * 2 / 10))
            .release()
        // 确定 C 和 D 的位置
        touchAction2.press(PointOption.point(x * 6 / 10, y * 6 / 10))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
            .moveTo(PointOption.point(x * 8 / 10, y * 8 / 10))
            .release()
        multiTouchAction.add(touchAction1).add(touchAction2)
        multiTouchAction.perform()

    }

    // 当测试用例运行完毕后，进行销毁
    @AfterTest
    fun tearDown() {
        androidDriver.quit()
    }

    companion object {
        lateinit var androidDriver: AndroidDriver<AndroidElement>
    }
}