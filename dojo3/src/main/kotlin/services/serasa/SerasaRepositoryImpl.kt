package services.serasa

import domain.entities.SerasaScore
import domain.repository.SerasaRepository
import java.math.BigDecimal

internal class SerasaRepositoryImpl(
    private val serasaService: SerasaService
) : SerasaRepository {

    override suspend fun getScore(name: String, cpf: String): SerasaScore {
        val score: Int = serasaService.getScore(name, cpf).score
        return SerasaScore(value = BigDecimal(score))
    }
}