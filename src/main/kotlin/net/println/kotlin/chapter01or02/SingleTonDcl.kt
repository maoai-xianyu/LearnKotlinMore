package net.println.kotlin.chapter01or02

/**
 *
 * @author zhangkun
 * @time 2020/8/7 12:20 下午
 */
class SingleTonDcl private constructor() {
    @Volatile
    private var mInstance: SingleTonDcl? = null

    fun getInstance(): SingleTonDcl? {
        if (mInstance == null) {
            synchronized(SingleTonDcl::class) {
                if (mInstance == null) {
                    mInstance = SingleTonDcl()
                }
            }
        }
        return mInstance
    }
}
