package com.dojo.external_services.controller

import com.dojo.external_services.dto.ProfilerUser
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import kotlinx.coroutines.delay
import kotlin.random.Random

fun profiler(route: Route) {
    route.post("/validate") {
        val post = call.receive<ProfilerUser>()
        val score: Int = Random.nextInt(0, 1000)
        delay(Random.nextLong(100,300))
        call.respond(mapOf("score" to score))
    }
}