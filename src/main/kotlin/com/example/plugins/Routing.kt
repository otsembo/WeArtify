package com.example.plugins

import com.example.data.repository.AppRepository
import com.example.presentation.controllers.client.artRoutes
import com.example.presentation.controllers.client.homeRoute
import com.example.presentation.controllers.client.rolesRouting
import io.ktor.application.*

fun Application.configureRouting() {
    // repository object
    val appRepository = AppRepository()

    homeRoute(appRepository)
    rolesRouting(appRepository)
    artRoutes(appRepository)
}
