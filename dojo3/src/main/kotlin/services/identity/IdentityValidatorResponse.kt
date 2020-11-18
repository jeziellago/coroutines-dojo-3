package services.identity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class IdentityValidatorResponse(@SerialName("score") val score: Double)