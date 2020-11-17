package domain.repository

import domain.entities.SerasaScore

interface SerasaRepository {

    suspend fun getScore(
        name: String,
        cpf: String
    ): SerasaScore
}
