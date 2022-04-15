package com.example.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table

@Serializable
data class CartStatus (
    val id:Long,
    val type:String,
)

object CartStatuses : LongIdTable("cart_status"){
    val type = varchar("status",20)
}