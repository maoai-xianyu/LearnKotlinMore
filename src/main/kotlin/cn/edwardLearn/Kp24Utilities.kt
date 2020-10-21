package cn.edwardLearn

/**
 * author:  zhangkun .
 * date:    on 2018/5/31.
 */

class Kp24Utilities {

    fun upper3FirstAnd3Last(str: String): String {
        return str.substring(0, 3).toUpperCase() + str.substring(3, str.length - 3) + str.substring(str.length - 3, str.length).toUpperCase()
    }
}