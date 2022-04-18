package com.example.presentation.controllers.client

import com.example.data.repository.AppRepository
import com.example.presentation.common.ApiExtensions.CLIENT_ENDPOINT
import com.example.presentation.common.paramToInt
import com.example.presentation.common.showResponse
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.artRouting(appRepository: AppRepository){

    routing {

        get("$CLIENT_ENDPOINT/art/{page}/{count}"){

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

        get("$CLIENT_ENDPOINT/art/latest"){

            call.respond(
                showResponse(
                    dataKey = "latest-art",
                    data = appRepository.artRepository.getLatestArt(5),
                    responseCode = 200,
                    message = "Success",
                )
            )

        }

        get("$CLIENT_ENDPOINT/art/related/{categoryId}"){

            call.respond(
                showResponse(
                    dataKey = "related-art",
                    data = appRepository.artRepository.getRelatedArt(
                        call.parameters.paramToInt(name = "categoryId", default = 1).toLong()
                    ),
                    responseCode = 200,
                    message = "Success",
                )
            )

        }

    }

}