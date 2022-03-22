package net.println.kotlinnew.chapter07.eg.json.ks

import kotlinx.serialization.*
import kotlinx.serialization.json.Json

// KS

@Serializable
data class PersonWithInits(val name: String, val age: Int){

    val firstName by lazy {
        name.split(" ")[0]
    }

    //@Transient
    val lastName = name.split(" ")[1]

}


fun main(){
    println(Json.encodeToString(PersonWithInits("Benny Huo", 18)))
    val personWithInits = Json.decodeFromString<PersonWithInits>("""{"name":"Benny Huo","age":20}""")
//    val personWithInits = Json.parse<PersonWithInits>("""{"name":"Benny Huo","age":20, "lastName":"Secret"}""")
    println(personWithInits.firstName)
    println(personWithInits.lastName)
}

//output:
//{"name":"Benny Huo","age":18,"lastName":"Huo"}
//Benny
//Huo