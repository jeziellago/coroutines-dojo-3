package com.dojo.external_services.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Document(
    @SerialName("document_type") val documentType: String,
    @SerialName("document_number") val documentNumber: String,
    @SerialName("document_photo") val documentPhoto: String,
    @SerialName("user_photo") val userPhoto: String,
)