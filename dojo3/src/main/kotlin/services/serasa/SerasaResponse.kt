package services.serasa

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SerasaResponse(@SerialName("score") val score: Int)