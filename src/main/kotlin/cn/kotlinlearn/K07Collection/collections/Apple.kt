package cn.kotlinlearn.K07Collection.collections

/**
 * author:  zhangkun .
 * date:    on 2018/3/20.
 */
class Apple(private val id: Int, private val price: Double) : Comparable<Apple> {

    override fun compareTo(other: Apple): Int {
        return if (Math.abs(this.price - other.price) < 0.001) {
            0
        } else {
            if (other.price - this.price > 0) 1 else -1
        }

    }

    override fun toString(): String {
        return "Apple(id=$id, price=$price)"
    }

}