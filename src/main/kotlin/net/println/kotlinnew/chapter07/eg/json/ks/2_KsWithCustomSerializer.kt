package net.println.kotlinnew.chapter07.eg.json.ks

import kotlinx.serialization.*
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.json.Json
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

@Serializable
data class PersonWithDate(val name: String, val age: Int,
                          @Serializable(with= DateSerializer::class)
                          val birthDate: Date
)

@Serializer(forClass = Date::class)
object DateSerializer: KSerializer<Date> {
    private val df: DateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm")

    override val descriptor: SerialDescriptor =
        PrimitiveSerialDescriptor("Date", StringDescriptor.kind as PrimitiveKind)

    override fun serialize(encoder: Encoder, obj: Date) {
        encoder.encodeString(df.format(obj))
    }

    override fun deserialize(decoder: Decoder): Date {
        return df.parse(decoder.decodeString())
    }
}

fun main(){
    println(Json.encodeToString(
        PersonWithDate(
            "Benny Huo",
            20,
            Date()
        )
    ))
    println(Json.decodeFromString<PersonWithDate>("""{"name":"Benny Huo","age":20,"birthDate":"2019-10-13 15:58"}"""))
}

//output:
//{"name":"Benny Huo","age":20,"birthDate":"2019-10-27 09:38"}
//PersonWithDate(name=Benny Huo, age=20, birthDate=Sun Oct 13 15:58:00 CST 2019)