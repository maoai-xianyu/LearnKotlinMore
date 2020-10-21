package net.println.kotlinnew.chapter07.eg.json.gson

import com.google.gson.Gson

// Gson

data class Person(val name: String, val age: Int)

fun main(){
    val gson = Gson()
    println(gson.toJson(Person("Benny Huo", 20)))
    println(gson.fromJson("""{"name":"Benny Huo","age":20}""", Person::class.java))
}

// output:
// {"name":"Benny Huo","age":20}
// Person(name=Benny Huo, age=20)