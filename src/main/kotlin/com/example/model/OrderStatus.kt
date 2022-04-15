package com.example.model

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class OrderStatus(
    val id:Long,
    val status:String,
)

object OrderStatuses : LongIdTable("order_status"){
    val status = varchar("status", 15)
}
