package com.example.model

@kotlinx.serialization.Serializable
data class Payment(
    val id:Long,
    val method: PaymentMethod,
    val amount:Double,
    val date:String,
    val status: PaymentStatus,
    val user: User,
    val order: Order

)

enum class PaymentStatus{
    NULL, COMPLETE, PENDING, FAILED
}
