package com.dojo.external_services.controller

import com.dojo.external_services.dto.UserIdentity
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import kotlin.random.Random

fun identityValidation(route: Route) {
    route.post("/validate") {
        withContext(Dispatchers.IO) {
            val post = call.receive<UserIdentity>()
            val score: Float = Random.nextFloat()
            //delay(Random.nextLong(100,300))
            delay(300)
            call.respond(mapOf("score" to score))
        }
    }
}