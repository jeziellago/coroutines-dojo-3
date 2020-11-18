package services.identity

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*


interface IdentityValidatorService {

    suspend fun getScore(
        name: String,
        rgImg: String,
        profileImg: String
    ): IdentityValidatorResponse

}

internal class IdentityValidatorServiceImpl(
    private val httpClient: HttpClient
) : IdentityValidatorService {

    override suspend fun getScore(
        name: String,
        rgImg: String,
        profileImg: String
    ): IdentityValidatorResponse = httpClient
        .post {
            url("http://127.0.0.1:8080/identity/validate")
            contentType(ContentType.Application.Json)
            body = IdentityValidatorRequest(name, rgImg, profileImg)
        }

}