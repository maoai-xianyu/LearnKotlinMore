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
        //desiredCapabilities.setCapability("noReset","true")
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
    fun testJiaKao() {

        // 1. 找到定位城市文本，并且点击
        androidDriver.findElementById("com.handsgo.jiakao.android:id/btn_agree").click()

        // 显示等待 替换上面 需要培训下面的所有 先用隐式等待
       /* val webDriverWait = WebDriverWait(androidDriver,10)
        val element = webDriverWait.until<AndroidElement>(ExpectedCondition {
            androidDriver.findElementById("com.handsgo.jiakao.android:id/btn_agree")
        })
        element.click()*/

        // 权限 弹框确定
        androidDriver.findElementById("com.handsgo.jiakao.android:id/permission_btn").click()
        // 权限 运行
        androidDriver.findElementById("com.lbe.security.miui:id/permission_allow_button_1").click()
        // 点击 重新选择 城市
        androidDriver.findElementById("com.handsgo.jiakao.android:id/tv_select_title").click()
        // 输入框输入北京
        //androidDriver.findElementById("com.handsgo.jiakao.android:id/edt_search_q").sendKeys("北京")

        // 结果值中有多个
        androidDriver.findElementById("com.handsgo.jiakao.android:id/edt_search_q").sendKeys("长")
        // 3. 找打搜索结果中的 北京 点击
        // 方案一： 默认点击的第一个，如果直接输入北京那只有一个直接点击就好，如果是多个，就默认是第一个
        // androidDriver.findElementById("com.handsgo.jiakao.android:id/item_title").click()

        // 方案二：多个相同的 id 值，放到集合中，通过索引回去，对应应用
        /*val findElements: List<AndroidElement> =
            androidDriver.findElementsById("com.handsgo.jiakao.android:id/item_title")
        findElements[2].click()*/

        // 方案三：根据文本值找到长沙  在 1.5 之后就不能使用了,有异常，用了 UIAutomator 替换
        // androidDriver.findElementByName("长沙".click()t

        // 方案四:根据文本值，找到长沙   UIAutomator 原生自动化引擎
        //androidDriver.findElementByAndroidUIAutomator("new UiSelector().text(\"长沙\")").click()

        // 方案五：使用 xpath 进行元素定位，这种方式是推荐的，有绝对定位和相对定位
        androidDriver.findElementByXPath("//android.widget.TextView[@text='长沙']").click()

        // 方案六：使用 accessibility id 找对应的元素 之后添加
        // 小车确定 默认选中
        // 滑动页面
        //   androidDriver.swipe  5.1.0 java-client  以下的方法在 之后没有了
        // 向上滑动
        swipeToUp(androidDriver, 2)
        // 5. 男生
        androidDriver.findElementById("com.handsgo.jiakao.android:id/tv_male").click()
        // 点击ok
        androidDriver.findElementById("com.handsgo.jiakao.android:id/tv_ok").click()
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