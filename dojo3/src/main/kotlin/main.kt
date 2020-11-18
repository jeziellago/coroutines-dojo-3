import di.loadDependencies
import domain.entities.AccountValidation
import domain.repository.IdentityValidatorRepository
import domain.repository.SerasaRepository
import kotlinx.coroutines.runBlocking
import locator.get
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime


@ExperimentalTime
fun main() {

    loadDependencies()

    val identityValidatorRepository = get<IdentityValidatorRepository>()
    val serasaRepository = get<SerasaRepository>()

    val accountValidations = mutableListOf<AccountValidation>()

    val elapsedTime = runBlocking {
        measureTime {
            val result = validateAccountUseCase(
                serasaRepository,
                identityValidatorRepository,
                fetchAccounts(10000) // 10.000 contas
            )
            accountValidations.addAll(result)
        }
    }

    accountValidations.map { accountValidation ->
        println(
            "[Account ${accountValidation.account.name}] " +
                    "approved=${accountValidation.approved} " +
                    "${accountValidation.serasaScore} " +
                    "${accountValidation.identityScore}"
        )
    }

    println("[TIME]: $elapsedTime")
}