package com.example.model

@kotlinx.serialization.Serializable
data class OrderStatus(
    val id:Long,
    val status:String,
)
