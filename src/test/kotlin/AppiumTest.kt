import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.android.AndroidElement
import io.appium.java_client.android.AndroidTouchAction
import java.net.MalformedURLException
import kotlin.jvm.JvmStatic
import org.openqa.selenium.remote.DesiredCapabilities
import java.lang.InterruptedException
import io.appium.java_client.touch.offset.PointOption
import io.appium.java_client.touch.WaitOptions
import java.net.URL
import java.time.Duration

object AppiumTest {
    private lateinit var androidDriver: AndroidDriver<AndroidElement>
    @Throws(MalformedURLException::class)
    @JvmStatic
    fun main(args: Array<String>) {

        // 1. 创建配置对象
        val desiredCapabilities = DesiredCapabilities()
        // 2. 添加配置
        // deviceName 可以找到我们的测试设备
        desiredCapabilities.setCapability("deviceName", "c890a5ce")
        // platformName 测试平台 Android or iOS
        desiredCapabilities.setCapability("platformName", "Android")
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
        // 启动服务，运行代码  会拉起应用\
        testJiaKao()
    }

    fun testJiaKao() {
        try {
            // 没有打开页面，先睡10秒
            Thread.sleep(5000)
            // 1. 找到定位城市文本，并且点击
            androidDriver.findElementById("com.handsgo.jiakao.android:id/btn_agree").click()
            Thread.sleep(15000)
            // 权限 弹框确定
            androidDriver.findElementById("com.handsgo.jiakao.android:id/permission_btn").click()
            // 权限 运行
            androidDriver.findElementById("com.lbe.security.miui:id/permission_allow_button_1").click()
            Thread.sleep(3000)
            // 点击 重新选择 城市
            androidDriver.findElementById("com.handsgo.jiakao.android:id/tv_select_title").click()
            Thread.sleep(2000)
            // 输入框输入北京
            androidDriver.findElementById("com.handsgo.jiakao.android:id/edt_search_q").sendKeys("北京")
            Thread.sleep(2000)
            // 3. 找打搜索结果中的 北京 点击
            androidDriver.findElementById("com.handsgo.jiakao.android:id/item_title").click()
            // 小车确定 默认选中
            // 滑动页面
            //   androidDriver.swipe  5.1.0 java-client  以下的方法在 之后没有了
            // 向上滑动
            swipeToUp(androidDriver, 2)
            Thread.sleep(2000)
            // 5. 男生
            androidDriver.findElementById("com.handsgo.jiakao.android:id/tv_male").click()
            // 点击ok
            androidDriver.findElementById("com.handsgo.jiakao.android:id/tv_ok").click()
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        } finally {
            androidDriver.quit()
        }
    }

    /**
     * 向上滑动
     * 第一个坐标（x / 2,8 * y / 10）:控制x轴在屏幕的中间点和y轴按压屏幕的坐标
     * 第二个坐标（x / 2, y / 5）：控制x轴在屏幕的中间点和y轴向上滑动的坐标停留点
     * @param driver
     * @param durtion 下一次滑动的时间
     */
    fun swipeToUp(driver: AndroidDriver<AndroidElement>, durtion: Long) {
        //获取手机屏幕的宽度
        val x = driver.manage().window().size.getWidth()
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
    fun swipeToDown(driver: AndroidDriver<AndroidElement>, durtion: Long) {
        //获取手机屏幕的宽度
        val x = driver.manage().window().size.getWidth()
        //获取手机屏幕的高度
        val y = driver.manage().window().size.getHeight()
        AndroidTouchAction(driver).press(PointOption.point(x / 2, y / 5))
            .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(durtion)))
            .moveTo(PointOption.point(x / 2, 8 * y / 10)).release().perform()
    }

    /**
     * 向左滑动
     * @param driver
     * @param durtion 下一次滑动的时间
     */
    fun swipeToLeft(driver: AndroidDriver<AndroidElement>, durtion: Long?) {
        //获取手机屏幕的宽度
        val x = driver.manage().window().size.getWidth()
        //获取手机屏幕的高度
        val y = driver.manage().window().size.getHeight()
        AndroidTouchAction(driver).press(PointOption.point(8 * x / 10, y / 2))
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
        AndroidTouchAction(driver).press(PointOption.point(x / 10, y / 2))
            .waitAction(
                WaitOptions.waitOptions(Duration.ofSeconds(durtion!!))
            )
            .moveTo(PointOption.point(8 * x / 10, y / 2)).release().perform()
    }
}