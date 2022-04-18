package com.example.presentation.controllers.client

import com.example.data.repository.AppRepository
import com.example.model.dto.CartRequest
import com.example.presentation.common.ApiExtensions.CLIENT_ENDPOINT
import com.example.presentation.common.ApiMessages.FAILED
import com.example.presentation.common.ApiMessages.POSTED
import com.example.presentation.common.ApiMessages.SUCCESS
import com.example.presentation.common.paramToInt
import com.example.presentation.common.showResponse
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.cartRouting(appRepository: AppRepository){

    routing {

        get("$CLIENT_ENDPOINT/cart/{userId}"){
            call.respond(
                showResponse(
                    dataKey = "cart-count",
                    data = appRepository.cartRepository.getUserActiveCart(
                        call.parameters.paramToInt("userId", -1).toLong()
                    ),
                    responseCode = 200,
                    message = SUCCESS
                )
            )
        }

        get("$CLIENT_ENDPOINT/cart/count/{userId}"){

            call.respond(
                showResponse(
                    dataKey = "user-cart",
                    data = appRepository.cartRepository.getUserActiveCartCount(
                        call.parameters.paramToInt("userId", -1).toLong()
                    ),
                    responseCode = 200,
                    message = SUCCESS
                )
            )

        }

        post("$CLIENT_ENDPOINT/cart/add"){

            val cart = try { call.receive<CartRequest>() }catch (ex:Exception){ null }

            call.respond(
                showResponse(
                    dataKey = POSTED,
                    data = cart,
                    responseCode = if(cart == null) 404 else 200,
                    message = if(cart == null) FAILED else SUCCESS
                )
            )

        }

    }

}