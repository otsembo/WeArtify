package com.example.presentation.controllers.client

import com.example.data.repository.AppRepository
import com.example.presentation.common.ApiExtensions.CLIENT_ENDPOINT
import com.example.presentation.common.paramToInt
import com.example.presentation.common.showResponse
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.rolesRouting(appRepository: AppRepository){
    routing {
        get("$CLIENT_ENDPOINT/roles"){

            call.respond(
                showResponse(
                dataKey = "roles",
                data = appRepository.roleRepository.getRoles(),
                responseCode = 200,
                message = "success"
            ))
        }
        get("$CLIENT_ENDPOINT/roles/{id}"){

            call.respond(
                showResponse(
                    dataKey = "role",
                    data = appRepository.roleRepository.getRoleById(
                        call.parameters.paramToInt("id", 0).toLong()
                    ),
                    responseCode = 200,
                    message = "success"
                )
            )
        }
    }
}