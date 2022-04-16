package com.example.presentation.controllers

import com.example.data.repository.AppRepository
import com.example.presentation.common.showResponse
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.artRoutes(appRepository: AppRepository){

    routing {

        get("/art/page/{num}"){

        }

        get("/art/latest"){

            call.respond(
                showResponse(
                    dataKey = "latest-art",
                    data = appRepository.artRepository.getLatestArt(),
                    responseCode = 200,
                    message = "Success"
                )
            )

        }

    }

}