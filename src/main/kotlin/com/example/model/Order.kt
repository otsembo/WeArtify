package com.example.model

@kotlinx.serialization.Serializable
data class Order(
    val id:Long,
    val items:String,
    val date:String,
    val status: OrderStatus,
    val paymentMethod: PaymentMethod,
    val customer: User,
    val deliveryPoint:String,
)
