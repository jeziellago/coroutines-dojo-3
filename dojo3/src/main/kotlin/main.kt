import domain.repository.IdentityValidatorRepository
import domain.repository.SerasaRepository
import locator.Locator
import services.identity.IdentityValidatorRepositoryImpl
import services.serasa.SerasaRepositoryImpl


fun main() {

    Locator.put(SerasaRepository::class) { SerasaRepositoryImpl() }
    Locator.put(IdentityValidatorRepository::class) { IdentityValidatorRepositoryImpl() }

}