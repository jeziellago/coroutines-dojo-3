package services.serasa

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SerasaRequest(
    @SerialName("name")
    val name: String,
    @SerialName("cpf")
    val cpf: String
)