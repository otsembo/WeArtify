package com.example.model

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

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

object Orders : Table("orders"){
    val id = long("id").autoIncrement()
    val items = text("items")
    val date = datetime("order_date")
    val status = reference("order_status", OrderStatuses.id)
    val paymentMethod = reference("payment_method", PaymentMethods.id)
    val customer = reference("user", Users.id)
    val deliveryPoint = text("delivery_point")
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(id)
}
