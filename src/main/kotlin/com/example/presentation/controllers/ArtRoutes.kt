package com.example.presentation.controllers

import com.example.data.repository.AppRepository
import com.example.model.Art
import com.example.presentation.common.paramToInt
import com.example.presentation.common.showResponse
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.artRoutes(appRepository: AppRepository){

    routing {

        get("/art/{page}/{count}"){

            with(call.parameters){

                call.respond(
                    showResponse(
                        dataKey = "art",
                        data = appRepository.artRepository.getArt(
                            page = paramToInt( name = "page", default = 1),
                            limit = paramToInt(name = "count", default = 5)
                        ),
                        responseCode = 200,
                        message = "Success",
                    )
                )

            }



        }

        get("/art/latest"){

            call.respond(
                showResponse(
                    dataKey = "latest-art",
                    data = appRepository.artRepository.getLatestArt(5),
                    responseCode = 200,
                    message = "Success",
                )
            )

        }

    }

}