package kwai

import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import java.net.MalformedURLException
import java.net.URL
import java.util.concurrent.TimeUnit

class KwaiTest {

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
        desiredCapabilities.setCapability("appPackage", "com.smile.gifmaker")
        // appActivity 测试启动app入口
        desiredCapabilities.setCapability("appActivity", "com.yxcorp.gifshow.HomeActivity")

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

        println(" 当前 activity dom ${androidDriver.currentActivity()}")

        println(" 当前 activity pacakge ${androidDriver.currentPackage}")

        val contains =
            "${androidDriver.currentPackage}/${androidDriver.currentActivity()}".contains("com.yxcorp.gifshow.HomeActivity")

        println("contains $contains")


        Thread.sleep(3000)

        androidDriver.adbStartActivityByDeeplink("kwai://rank/aggregation")

        println("打开快手榜单")

        Thread.sleep(10000)
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

