package com.example.model

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class OrderStatus(
    val id:Long,
    val status:String,
)

object OrderStatuses : Table("order_status"){
    val id = long("id").autoIncrement()
    val status = varchar("status", 15)
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(id)
}
