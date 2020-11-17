package com.dojo.external_services.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BankUser(
    @SerialName("name") val name: String,
    @SerialName("last_name") val lastName: String,
    @SerialName("birth_date") val birthDate: String,
    @SerialName("document") val document: Document
) {

}