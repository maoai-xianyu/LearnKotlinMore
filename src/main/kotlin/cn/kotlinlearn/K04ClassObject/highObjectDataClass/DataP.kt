package cn.kotlinlearn.K04ClassObject.highObjectDataClass

/**
 * Created by zhangkun on 2017/6/5.
 *
 * 声明数据类
 * 主构造函数的参数列表必须使用 val / var 声明为类属性，而且要求至少有一个，否则无法通过编译
 */
data class DataP(val name: String,var age:Int)