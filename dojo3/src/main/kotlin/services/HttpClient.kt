package services

import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*

object HttpClient {

    val client by lazy {
        HttpClient(Apache) {
            install(JsonFeature) {
                serializer = createSerializer()
            }
        }
    }

    private fun createSerializer() =
        KotlinxSerializer(
            kotlinx.serialization.json.Json {
                isLenient = false
                ignoreUnknownKeys = true
            }
        )
}