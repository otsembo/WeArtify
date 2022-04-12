package com.example.model

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class PaymentMethod(
    val id:Long,
    val name:String,
)

object PaymentMethods : Table("payment_method"){
    val id = long("id").autoIncrement()
    val method = varchar("method", 25)
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(id)
}
