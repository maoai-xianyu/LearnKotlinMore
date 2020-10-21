package cn.kotlinlearn.K08TypeExtension

/**
 * author:  zhangkun .
 * date:    on 2018/3/21.
 */
fun <T> MutableList<T>.swap(indexOne: Int, indexTwo: Int) {

    val temp = this[indexOne]
    this[indexOne] = this[indexTwo]
    this[indexTwo] = temp
}

val Int.isOdd: Boolean
    get() = this and 1 == 1