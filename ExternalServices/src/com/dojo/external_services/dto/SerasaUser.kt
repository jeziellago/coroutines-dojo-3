package com.dojo.external_services.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SerasaUser(
    @SerialName("name") val name: String,
    @SerialName("cpf") val documentCpf: String
)