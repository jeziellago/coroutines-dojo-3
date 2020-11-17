package services.identity

import domain.entities.IdentityScore
import domain.repository.IdentityValidatorRepository
import kotlinx.coroutines.delay
import java.math.BigDecimal
import kotlin.random.Random

class IdentityValidatorRepositoryImpl : IdentityValidatorRepository {

    override suspend fun getScore(rgImg: String, profileImg: String): IdentityScore {
        delay(300L)
        return IdentityScore(value = BigDecimal.valueOf(Random.nextDouble()))
    }
}