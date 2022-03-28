fun main(args: Array<String>) {


    true.not().let {
        println(" this is true $it")
    }


    val sss = sequenceOf(21, 40, 11, 33, 78)


    val sssss: Sequence<Int> = sss.filter {
        it % 3 == 0
    }

    println(sssss.toList())


    val lsit = listOf<Int>(21, 40, 11, 33, 78)

    val filter = lsit.filter {
        it % 3 == 0
    }

    println(filter)
}