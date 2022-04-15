package com.example.model

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class PaymentMethod(
    val id:Long,
    val name:String,
)

object PaymentMethods : LongIdTable("payment_method"){
    val method = varchar("method", 25)
}
