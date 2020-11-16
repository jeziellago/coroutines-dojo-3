package services.serasa

import domain.entities.SerasaScore
import domain.repository.SerasaRepository
import kotlinx.coroutines.delay
import java.math.BigDecimal
import kotlin.random.Random

class SerasaRepositoryImpl : SerasaRepository {

    override suspend fun getScore(name: String, cpf: String): SerasaScore {
        delay(200L)
        return SerasaScore(value = BigDecimal.valueOf(Random.nextDouble()))
    }
}