package domain.repository

import domain.entities.IdentityScore


interface IdentityValidatorRepository {

    suspend fun getScore(
        rgImg: String,
        profileImg: String
    ): IdentityScore
}
