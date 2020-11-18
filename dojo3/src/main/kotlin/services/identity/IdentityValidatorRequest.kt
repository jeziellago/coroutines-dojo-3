package services.identity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class IdentityValidatorRequest(
    @SerialName("name")
    val name: String,
    @SerialName("rg_img")
    val rgImg: String,
    @SerialName("profile_img")
    val profileImg: String
)