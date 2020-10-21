package cn.kotlinlearn.domain

import java.io.Serializable

/**
 * Created by zhangkun on 2017/5/12.
 */

data class UserDomain(var name: String, var id: String) : Serializable{
    override fun toString(): String {
        return "UserDomain{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}'
    }
}
