package com.example.plugins

import com.example.data.repository.AppRepository
import com.example.presentation.controllers.client.artRouting
import com.example.presentation.controllers.client.cartRouting
import com.example.presentation.controllers.client.homeRouting
import com.example.presentation.controllers.client.rolesRouting
import io.ktor.application.*

fun Application.configureRouting() {
    // repository object
    val appRepository = AppRepository()

    homeRouting(appRepository)
    rolesRouting(appRepository)
    artRouting(appRepository)
    cartRouting(appRepository)
}
