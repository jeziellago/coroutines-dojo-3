package validateAccount

import domain.entities.*
import domain.entities.IdentityScore
import domain.entities.SerasaScore
import domain.repository.IdentityValidatorRepository
import domain.repository.SerasaRepository
import kotlinx.coroutines.runBlocking
import org.junit.Test
import validateAccountUseCase
import java.math.BigDecimal
import kotlin.test.assertEquals

class ValidateAccountUseCaseTest {

    @Test
    fun should_validate_approved_account() {
        runBlocking {
            val accounts: List<Account> = listOf(
                Account(
                    name = "Jeziel",
                    cpf = CPF(value = "123.124.123-12"),
                    rgImg = "RgImg",
                    profileImg = "image"
                )
            )

            var list = validateAccountUseCase(
                this,
                SerasaRepositoryStub(BigDecimal("300")),
                IdentityValidatorRepositoryStub(BigDecimal("0.75")),
                accounts
            )
            assertEquals(true, list[0].approved)
        }
    }

    @Test
    fun should_validate_not_approved_account() {
        runBlocking {
            val accounts: List<Account> = listOf(
                Account(
                    name = "Jeziel",
                    cpf = CPF(value = "123.124.123-12"),
                    rgImg = "RgImg",
                    profileImg = "image"
                )
            )

            var list = validateAccountUseCase(
                this,
                SerasaRepositoryStub(BigDecimal("299.9")),
                IdentityValidatorRepositoryStub(BigDecimal("0.75")),
                accounts
            )
            assertEquals(false, list[0].approved)
        }
    }
}

class IdentityValidatorRepositoryStub(
    val score: BigDecimal
) : IdentityValidatorRepository {
    override suspend fun getScore(name: String, rgImg: String, profileImg: String) = IdentityScore(score)
}

class SerasaRepositoryStub(
    val score: BigDecimal
) : SerasaRepository {
    override suspend fun getScore(name: String, cpf: String) = SerasaScore(score)
}