package com.example.plugins

import com.example.data.repository.AppRepository
import com.example.presentation.controllers.homeRoute
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.request.*

fun Application.configureRouting() {
    // repository object
    val appRepository = AppRepository()

    homeRoute(appRepository)
}
