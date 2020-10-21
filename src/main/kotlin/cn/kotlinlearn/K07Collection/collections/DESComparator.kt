package cn.kotlinlearn.K07Collection.collections

/**
 * author:  zhangkun .
 * date:    on 2018/3/20.
 */
class DESComparator : Comparator<Banana> {
    override fun compare(o1: Banana, o2: Banana): Int {
        return if (Math.abs(o1.price - o2.price) < 0.001) {
            0
        } else {
            if (o1.price - o2.price > 0) 1 else -1
        }
    }

}