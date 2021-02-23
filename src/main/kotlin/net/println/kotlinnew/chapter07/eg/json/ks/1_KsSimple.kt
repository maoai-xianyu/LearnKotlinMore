package net.println.kotlinnew.chapter07.eg.json.ks

import kotlinx.serialization.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.encodeToString

//Kotlinx.serialization

@Serializable
data class Person(val name: String, val age: Int)


fun main(){
    println(Json.encodeToString(Person("Benny Huo", 20)))
    println(Json.decodeFromString<Person>("""{"name":"Benny Huo","age":20}"""))
}

//output:
//{"name":"Benny Huo","age":20}
//Person(name=Benny Huo, age=20)