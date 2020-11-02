package net.println.kotlinnew.chapter08.variances

/**
 *
 * @author zhangkun
 * @time 2020/10/28 11:58 下午
 */
fun main() {


    // 能够比较int的一定能比较Number,所以Comparable<Int> 是 Comparable<Number>父类
    val intComparable: Comparable<Int> = object : Comparable<Number> {
        override fun compareTo(other: Number): Int {
            return 0
        }
    }


}

interface Book

interface EduBook : Book

// 生产者
class BookStore<out T : Book> {
    fun getBook(): T {
        TODO()
    }
}

fun covariant() {
    val eduBookStore: BookStore<EduBook> = BookStore<EduBook>()
    val bookStore: BookStore<Book> = eduBookStore

    val book: Book = bookStore.getBook()
    val eduBook: EduBook = eduBookStore.getBook()
}


open class Waste

class DryWaste : Waste()

//消费者
class Dustbin<in T : Waste> {
    fun put(t: T) {
        TODO()
    }
}

fun contravariant(){
    // 垃圾桶
    val dustbin: Dustbin<Waste> = Dustbin<Waste>()
    // 干垃圾
    val dryWasteDustbin: Dustbin<DryWaste> = dustbin

    val waste = Waste()
    val dryWaste = DryWaste()

    // 垃圾桶可以放很多种垃圾
    dustbin.put(waste)
    dustbin.put(dryWaste)
    // 干垃圾桶只能放干垃圾
//    dryWasteDustbin.put(waste)
    dryWasteDustbin.put(dryWaste)
}

