package cn.kotlinlearn.domain

import java.io.Serializable

/**
 * Created by zhangkun on 2017/5/12.
 */
class UserDomainOne : Serializable {
    var name: String? = null
    var id: String? = null

    constructor(name: String) {
        this.name = name
    }

    constructor(name: String, id: String) {
        this.name = name
        this.id = id
    }

    override fun toString(): String {
        return "UserDomainOne(name=$name, id=$id)"
    }

}