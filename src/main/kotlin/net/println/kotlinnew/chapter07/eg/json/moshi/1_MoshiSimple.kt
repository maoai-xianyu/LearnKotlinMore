package net.println.kotlinnew.chapter07.eg.json.moshi

import com.squareup.moshi.Moshi

//Moshi

data class Person(val name: String, val age: Int)

fun main(){
    val moshi = Moshi.Builder().build()
    val jsonAdapter = moshi.adapter(Person::class.java)
    println(jsonAdapter.toJson(Person("Benny Huo", 20)))
    println(jsonAdapter.fromJson("""{"name":"Benny Huo","age":20}"""))
}

// output:
//{"age":20,"name":"Benny Huo"}
//Person(name=Benny Huo, age=20)