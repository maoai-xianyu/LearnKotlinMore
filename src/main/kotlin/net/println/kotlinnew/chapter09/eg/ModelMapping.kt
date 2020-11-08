package net.println.kotlinnew.chapter09.eg

import java.lang.IllegalArgumentException
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

// 用数据类的属性去查找对应map或者UserDTO属性
//mapping fields. Using Annotations next chapter.
data class UserVO(val login: String, val avatarUrl: String)

data class UserDTO(
    var id: Int,
    var login: String,
    var avatarUrl: String,
    var url: String,
    var htmlUrl: String
)

fun main() {
    val userDTO = UserDTO(
        0,
        "Bennyhuo",
        "https://avatars2.githubusercontent.com/u/30511713?v=4",
        "https://api.github.com/users/bennyhuo",
        "https://github.com/bennyhuo"
    )

    val userVO: UserVO = userDTO.mapAs()
    println(userVO)

    println("----------")

    val userMap = mapOf(
        "id" to 0,
        "login" to "Bennyhuo",
        "avatarUrl" to "https://api.github.com/users/bennyhuo",
        "url" to "https://api.github.com/users/bennyhuo"
    )

    val userVOFromMap: UserVO = userMap.mapAs()
    println(userVOFromMap)
}

inline fun <reified From : Any, reified To : Any> From.mapAs(): To {
    /*return From::class.memberProperties.map { it.name to it.get(this) }
        .toMap().mapAs()*/
    // 转换
    val toMap = From::class.memberProperties.map { it.name to it.get(this) }
        .toMap()
    return To::class.primaryConstructor!!.let {
        // 参数
        it.parameters.map { parameter ->
            parameter to (toMap[parameter.name] ?: if (parameter.type.isMarkedNullable) null
            else throw IllegalArgumentException("${parameter.name} is required but missing."))
        }.toMap().let(it::callBy)
    }
}

// reified 具体化
inline fun <reified To : Any> Map<String, Any?>.mapAs(): To {
    // 主构造器，数据类
    return To::class.primaryConstructor!!.let {
        // 参数
        it.parameters.map { parameter ->
            println("parameter $parameter")
            println("parameter.name ${parameter.name}")
            println("parameter.name value ${this[parameter.name]}")
            println("parameter.type ${parameter.type.isMarkedNullable}")
            parameter to (this[parameter.name] ?: if (parameter.type.isMarkedNullable) null
            else throw IllegalArgumentException("${parameter.name} is required but missing."))
        }.toMap().let(it::callBy) // it 代表的是 primaryConstructor
    }
}