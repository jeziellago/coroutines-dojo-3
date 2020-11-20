import domain.entities.Account
import domain.entities.AccountValidation
import domain.entities.IdentityScore
import domain.entities.SerasaScore
import domain.repository.IdentityValidatorRepository
import domain.repository.SerasaRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

suspend fun validateAccountUseCase(
    coroutineScope: CoroutineScope,
    serasaRepository: SerasaRepository,
    identityValidatorRepository: IdentityValidatorRepository,
    accounts: List<Account>
): List<AccountValidation> {
    return accounts.map {
        coroutineScope.async {
            val serasaScore = serasaRepository.getScore(it.name, it.cpf.value)
            val identityScore = identityValidatorRepository.getScore(
                name = it.name, rgImg = it.rgImg, profileImg = it.profileImg
            )

            AccountValidation(
                it,
                identityScore.value >= 0.75.toBigDecimal() && serasaScore.value >= 300.toBigDecimal(),
                serasaScore,
                identityScore
            )
        }
    }.map {
        it.await()
    }
}

// Usar dados da accounts: List<Account> para
// Pegar os dados do SearasaRepository
// Pegar os dados do IdentityValidator

