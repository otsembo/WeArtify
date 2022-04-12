package com.example.model

@kotlinx.serialization.Serializable
data class PaymentMethod(
    val id:Long,
    val name:String,
)
