package com.example.model

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

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

enum class PaymentStatus(val status:String){
    NULL("null"), COMPLETE("complete"), PENDING("pending"), FAILED("failed")
}

object Payments :LongIdTable("payments"){
    val method = reference("payment_method", PaymentMethods.id)
    val amount = double("amount")
    val date = datetime("date")
    val status = enumeration("payment_status", PaymentStatus::class)
    val user = reference("user_id",Users.id)
    val order = reference("order_id", Orders.id)
}


