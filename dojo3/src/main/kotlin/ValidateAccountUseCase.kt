import domain.entities.Account
import domain.entities.AccountValidation
import domain.repository.IdentityValidatorRepository
import domain.repository.SerasaRepository

suspend fun validateAccountUseCase(
    serasaRepository: SerasaRepository,
    identityValidatorRepository: IdentityValidatorRepository,
    accounts: List<Account>
): List<AccountValidation> {
    TODO("")
}