package com.tikaani

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.tikaani.plugins.*
import io.ktor.serialization.gson.*
import io.ktor.server.plugins.contentnegotiation.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)

}

fun Application.module() {
    configureSerialization()
    configureRouting()
}

fun Application.main(){
    install(ContentNegotiation) {
        gson()
    }
}