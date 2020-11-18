package domain.repository

import domain.entities.IdentityScore


interface IdentityValidatorRepository {

    suspend fun getScore(
        name: String,
        rgImg: String,
        profileImg: String
    ): IdentityScore
}
