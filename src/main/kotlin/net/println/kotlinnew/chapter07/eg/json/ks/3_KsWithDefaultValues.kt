package net.println.kotlinnew.chapter07.eg.json.ks

import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

// KS

@Serializable
data class PersonWithDefaults(val name: String, val age: Int = 18)


fun main(){
    println(Json.encodeToString(PersonWithDefaults("Benny Huo")))
    println(Json.decodeFromString<PersonWithDefaults>("""{"name":"Benny Huo"}"""))
}

//output:
//{"name":"Benny Huo","age":18}
//PersonWithDefaults(name=Benny Huo, age=18)