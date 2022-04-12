package com.example.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class CartStatus (
    val id:Long,
    val type:String,
)

object CartStatuses : Table("cart_status"){
    val id = long("id").autoIncrement()
    val type = varchar("status",20)

    override val primaryKey: PrimaryKey
        get() = PrimaryKey(id)
}