package com.example.presentation.controllers

import com.example.domain.model.ApiResponse
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.homeRoute(){

    routing {

        get("/"){
            call.respond( ApiResponse<String>(status = 200, message = "app started successfully", data = null) )
        }

        get("/home"){

        }

    }

}