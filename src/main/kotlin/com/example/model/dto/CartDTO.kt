package com.example.model.dto

@kotlinx.serialization.Serializable
data class CartRequest(
    val user:Long,
    val items: List<CartItem>,
)

@kotlinx.serialization.Serializable
data class CartItem(
    val productId:Long,
    val qty:Long,
)