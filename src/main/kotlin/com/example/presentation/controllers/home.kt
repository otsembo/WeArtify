package com.example.presentation.controllers

import com.example.data.repository.AppRepository
import com.example.domain.model.ApiResponse
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.homeRoute(appRepository: AppRepository){

    routing {

        get("/"){
            call.respond( ApiResponse<String>(status = 200, message = "app started successfully", data = null) )
        }

        get("/home"){

        }

        get("/roles"){
            val data = appRepository.roleRepository.getRoles()
            call.respond(ApiResponse(status = 200, message = "success", data = data))
        }

    }

}