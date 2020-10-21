package cn.kotlinlearn.tools


/**
 * Created by zhangkun on 2017/5/11.
 * 用于扩展函数
 */
/*fun Context.toast(msg: String?, length: Int = Toast.LENGTH_LONG) {
    Toast.makeText(this, msg, length).show()
}*/


fun to(): String = "mmms"


fun isOdd(num: Int): Boolean {
    return num % 2 == 1
}