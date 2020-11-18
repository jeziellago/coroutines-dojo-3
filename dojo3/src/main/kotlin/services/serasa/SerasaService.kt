package services.serasa

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*

interface SerasaService {

    suspend fun getScore(name: String, cpf: String): SerasaResponse
}

class SerasaServiceImpl(
    private val httpClient: HttpClient
): SerasaService {

    override suspend fun getScore(
        name: String,
        cpf: String
    ): SerasaResponse = httpClient.post {
        url("http://127.0.0.1:8080/serasa/score")
        contentType(ContentType.Application.Json)
        body = SerasaRequest(name, cpf)
    }
}