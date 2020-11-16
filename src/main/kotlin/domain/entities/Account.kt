package domain.entities

data class Account(
    val username: String,
    val cpf: CPF,
    val rgImg: String,
    val profileImg: String
)

data class CPF(val value: String)