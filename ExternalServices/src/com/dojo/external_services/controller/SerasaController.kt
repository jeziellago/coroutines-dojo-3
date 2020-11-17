package com.dojo.external_services.controller

import com.dojo.external_services.dto.SerasaUser
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.coroutines.delay
import kotlin.random.Random

fun serasa(route: Route) {
    route.post("/score") {
        val post = call.receive<SerasaUser>()
        val score: Int = Random.nextInt(0, 1000)
        delay(Random.nextLong(100,300))
        call.respond(mapOf("score" to score))
    }
}