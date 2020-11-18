package di

import domain.repository.IdentityValidatorRepository
import domain.repository.SerasaRepository
import locator.get
import locator.provides
import services.identity.IdentityValidatorRepositoryImpl
import services.identity.IdentityValidatorService
import services.identity.IdentityValidatorServiceImpl
import services.serasa.SerasaRepositoryImpl
import services.serasa.SerasaService
import services.serasa.SerasaServiceImpl

fun loadDependencies() {
    provides { services.HttpClient.client }

    provides<SerasaService> { SerasaServiceImpl(httpClient = get()) }
    provides<SerasaRepository> { SerasaRepositoryImpl(serasaService = get()) }

    provides<IdentityValidatorService> { IdentityValidatorServiceImpl(httpClient = get()) }
    provides<IdentityValidatorRepository> { IdentityValidatorRepositoryImpl(identityValidatorService = get()) }
}