package com.dojo.external_services.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SerasaUser(
    @SerialName("first_name") val firstName: String,
    @SerialName("last_name") val lastName: String,
    @SerialName("cpf") val documentCpf: String,
    @SerialName("birth_date") val birthDate: String,
)