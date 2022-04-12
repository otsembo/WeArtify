package com.example

import com.example.data.database.configureDB
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

fun main() {
    embeddedServer(Netty, port = 4040, host = "127.0.0.1") {
        configureRouting()
        configureSerialization()
        configureDB()
    }.start(wait = true)
}
