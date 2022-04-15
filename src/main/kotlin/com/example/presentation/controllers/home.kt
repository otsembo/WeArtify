package com.example.presentation.controllers

import com.example.data.repository.AppRepository
import com.example.domain.model.ApiResponse
import com.example.domain.model.HomePageResponse
import com.example.domain.use_cases.RetrieveArtCategories
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.homeRoute(appRepository: AppRepository){

    routing {

        get("/"){
            call.respond( ApiResponse<String>(status = 200, message = "app started successfully", data = null) )
        }

        get("/home"){

            val banners = appRepository.homeRepository.getActiveHomeBanners()
            val artCategories = RetrieveArtCategories.fetchCategories()

            val homePageResponse = HomePageResponse(banners,artCategories)

            call.respond(ApiResponse(status = 200, message = "success", homePageResponse))

        }

    }

}