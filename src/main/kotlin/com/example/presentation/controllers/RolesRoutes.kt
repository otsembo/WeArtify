package com.example.presentation.controllers

import com.example.data.repository.AppRepository
import com.example.domain.model.ApiResponse
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.rolesRouting(appRepository: AppRepository){
    routing {
        get("/roles"){
            val data = appRepository.roleRepository.getRoles()
            call.respond(ApiResponse(status = 200, message = "success", data = data))
        }
        get("roles/{id}"){
            val roleId = call.parameters["id"]

            try {

                roleId?.let {
                    val data = appRepository.roleRepository.getRoleById(it.toLong())
                    call.respond(ApiResponse(status = 200, message = "success", data))
                }

            }catch (ex:Exception){
                call.respond(ApiResponse<String?>(status = 404, message = ex.localizedMessage, data = null))
            }

        }
    }
}