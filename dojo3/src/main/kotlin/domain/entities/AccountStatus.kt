package domain.entities


data class AccountValidation(
    val account: Account,
    val approved: Boolean,
    val serasaScore: SerasaScore,
    val identityScore: IdentityScore
)