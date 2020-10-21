package cn.edwardLearn.kp54kotlin

/**
 * create by zhangkun .
 * on 2018/10/30
 */
class CatTestDomain(var color: Int) {

    var model = ""
    var year = 0

    val name = "domian"

    constructor(model: String) : this(model.hashCode().toInt()){
        this.model = model
    }

    constructor(model:String,color:Int) : this(color)

    constructor(model: String,color: Int, year:Int) : this(color){
        this.model = model
        this.color = color
        this.year = year
    }
}

fun topLevelDomain() = println("this is a top level function in Car Kotlin")