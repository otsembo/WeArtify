package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class Cart(
    val id:Long,
    val status: CartStatus,
    val item: Art,
    val date:String,
    val qty:Int,
    val totalPrice:Double,
    val user: User,
)
