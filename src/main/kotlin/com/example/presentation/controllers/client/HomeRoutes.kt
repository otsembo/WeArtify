package com.example.presentation.controllers.client

import com.example.data.repository.AppRepository
import com.example.domain.use_cases.RetrieveArtCategories
import com.example.presentation.common.ApiExtensions.CLIENT_ENDPOINT
import com.example.presentation.common.showResponse
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.homeRoute(appRepository: AppRepository){

    routing {

        get("/"){
            call.respond(
                showResponse(
                    "app",
                    data = "started successfully",
                    responseCode = 200,
                    message = "app"
                )
            )
        }

        get("$CLIENT_ENDPOINT/banners"){

            call.respond(
                showResponse(
                    dataKey = "banners",
                    data = appRepository.homeRepository.getBanners(),
                    responseCode = 200,
                    message = "success"
                )
            )

        }

        get("$CLIENT_ENDPOINT/banners/active"){

            call.respond(
                showResponse(
                    dataKey = "activeBanners",
                    data = appRepository.homeRepository.getActiveHomeBanners(),
                    responseCode = 200,
                    message = "success"
                )
            )

        }

        get("$CLIENT_ENDPOINT/categories"){

            call.respond(
                showResponse(
                    dataKey = "categories",
                    data = RetrieveArtCategories.fetchCategories(),
                    responseCode = 200,
                    message = "success"
                )
            )

        }

    }

}