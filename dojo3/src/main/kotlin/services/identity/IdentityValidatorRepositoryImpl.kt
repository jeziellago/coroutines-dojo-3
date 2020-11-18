package services.identity

import domain.entities.IdentityScore
import domain.repository.IdentityValidatorRepository
import java.math.BigDecimal

class IdentityValidatorRepositoryImpl(
        private val identityValidatorService: IdentityValidatorService
) : IdentityValidatorRepository {

    override suspend fun getScore(
        name: String,
        rgImg: String,
        profileImg: String
    ): IdentityScore {
        val score = identityValidatorService.getScore(name, rgImg, profileImg).score
        return IdentityScore(value = BigDecimal(score))
    }
}