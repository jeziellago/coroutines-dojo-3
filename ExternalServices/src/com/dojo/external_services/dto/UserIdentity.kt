package com.dojo.external_services.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserIdentity(
    @SerialName("name") val name: String,
    @SerialName("rg_img") val rgImg: String,
    @SerialName("profile_img") val profileImg: String,
)