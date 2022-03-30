package appium

import io.appium.java_client.TouchAction
import org.testng.annotations.BeforeTest
import java.net.MalformedURLException
import org.openqa.selenium.remote.DesiredCapabilities
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.android.AndroidTouchAction
import io.appium.java_client.touch.WaitOptions
import io.appium.java_client.touch.offset.PointOption
import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait
import java.lang.InterruptedException
import org.testng.annotations.AfterTest
import org.testng.annotations.Test
import java.net.URL
import java.time.Duration
import java.util.concurrent.TimeUnit

class AppiumTestUnitKt {
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
        desiredCapabilities.setCapability("automationName","uiautomator2")
        // noReset 每次进入应用，不清除应用数据 true 是不清除 默认是 false 和  Thread.sleep(10000) 配合，需要 @Test(enabled = false)
        desiredCapabilities.setCapability("noReset",true)
        // appPackage 找到要测试的app  驾考宝典
        desiredCapabilities.setCapability("appPackage", "com.handsgo.jiakao.android")
        // appActivity 测试启动app入口
        desiredCapabilities.setCapability("appActivity", "com.handsgo.jiakao.android.splash.Login")

        // 3. 创建驱动
        // 传入两个参数
        // 第一个参数：appium通讯地址
        // 第二个参数：配置对象
        androidDriver = AndroidDriver(
            URL("http://127.0.0.1:4723/wd/hub"),
            desiredCapabilities
        )
        // 30s 隐式等待
        androidDriver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS)
    }

    @Test
    @Throws(InterruptedException::class)
    fun testRefresh() {

        // com.github.appium:java-client  5.0  以前的版本  滑动可以用 androidDriver.swipe() 之后用别的方法
        Thread.sleep(10000)
        val touchAction = AndroidTouchAction(androidDriver)
        // 把原始坐标转换成 PointOption
        val optionStart = PointOption.point(356,594)
        val optionEnd = PointOption.point(356,794)
        // 把原始时间转换成 WaitOptions 类型
        val waitOptions = WaitOptions.waitOptions(Duration.ofSeconds(2))
        touchAction.press(optionStart)
            .waitAction(waitOptions)
            .moveTo(optionEnd)
            .release()
            .perform()

        Thread.sleep(10000)
    }

    //  需要修改 修改对应的app 目前没有，就先放在这里处理
    @Test(enabled = false)
    @Throws(InterruptedException::class)
    fun testMultiSwipe(){

        Thread.sleep(10000)
        val touchAction = AndroidTouchAction(androidDriver)
        // 把原始坐标转换成 PointOption
        val option1 = PointOption.point(150,427)
        val option2 = PointOption.point(362,427)
        val option3 = PointOption.point(569,427)
        val option4 = PointOption.point(369,525)
        val option5 = PointOption.point(150,850)
        val option6 = PointOption.point(362,850)
        val option7 = PointOption.point(569,850)
        touchAction.press(option1)
            .moveTo(option2)
            .moveTo(option3)
            .moveTo(option4)
            .moveTo(option5)
            .moveTo(option6)
            .moveTo(option7)
            .release()
            .perform()

        Thread.sleep(10000)
        //z 字解锁 九宫格 1--  150  427   2-- 362  427  3-- 569 427
        //九宫格 4--  369  525
        // 5-- 150  850
        // 6-- 362  850
        // 7-- 569  850
    }


    /**
    * 向上滑动
    * 第一个坐标（x / 2,8 * y / 10）:控制x轴在屏幕的中间点和y轴按压屏幕的坐标
    * 第二个坐标（x / 2, y / 5）：控制x轴在屏幕的中间点和y轴向上滑动的坐标停留点
    * @param driver
    * @param durtion 下一次滑动的时间
    */
    fun swipeToUp(driver: AndroidDriver<AndroidElement>?, durtion: Long) {
        //获取手机屏幕的宽度
        val x = driver!!.manage().window().size.getWidth()
        //获取手机屏幕的高度
        val y = driver.manage().window().size.getHeight()
        AndroidTouchAction(driver).press(PointOption.point(x / 2, 8 * y / 10))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(durtion)))
            .moveTo(PointOption.point(x / 2, y / 5)).release().perform()
    }

    /**
     * 向下滑动
     * @param driver
     * @param durtion 下一次滑动的时间
     */
    fun swipeToDown(driver: AndroidDriver<AndroidElement?>, durtion: Long) {
        //获取手机屏幕的宽度
        val x = driver.manage().window().size.getWidth()
        //获取手机屏幕的高度
        val y = driver.manage().window().size.getHeight()
        TouchAction<AndroidTouchAction>(driver).press(PointOption.point(x / 2, y / 5))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(durtion)))
            .moveTo(PointOption.point(x / 2, 8 * y / 10)).release().perform()
    }

    /**
     * 向左滑动
     * @param driver
     * @param durtion 下一次滑动的时间
     */
    fun swipeToLeft(driver: AndroidDriver<AndroidElement?>, durtion: Long?) {
        //获取手机屏幕的宽度
        val x = driver.manage().window().size.getWidth()
        //获取手机屏幕的高度
        val y = driver.manage().window().size.getHeight()
        TouchAction<AndroidTouchAction>(driver).press(PointOption.point(8 * x / 10, y / 2))
            .waitAction(
                WaitOptions.waitOptions(Duration.ofSeconds(durtion!!))
            )
            .moveTo(PointOption.point(x / 10, y / 2)).release().perform()
    }

    /**
     * 向左滑动
     * @param driver
     * @param durtion 下一次滑动的时间
     */
    fun swipeToRight(driver: AndroidDriver<AndroidElement?>, durtion: Long?) {
        //获取手机屏幕的宽度
        val x = driver.manage().window().size.getWidth()
        //获取手机屏幕的高度
        val y = driver.manage().window().size.getHeight()
        TouchAction<AndroidTouchAction>(driver).press(PointOption.point(x / 10, y / 2))
            .waitAction(
                WaitOptions.waitOptions(Duration.ofSeconds(durtion!!))
            )
            .moveTo(PointOption.point(8 * x / 10, y / 2)).release().perform()
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