package com.dojo.external_services.routes

import com.dojo.external_services.controller.bankAccount
import com.dojo.external_services.controller.identityValidation
import com.dojo.external_services.controller.serasa
import io.ktor.routing.*

fun routes(routing: Routing) {
    routing.route("/identity", ::identityValidation)
    routing.route("/serasa", ::serasa)
    routing.route("/bank/account", ::bankAccount)
}

