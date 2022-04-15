package com.example.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

@Serializable
data class Cart(
    val id:Long,
    val status: CartStatus,
    val item: Art,
    val date:String,
    val qty:Int,
    val totalPrice:Double,
    val user: User,
)

object Carts : LongIdTable("cart"){
    val status = reference("status_id", CartStatuses.id)
    val art = reference("art_id", ArtPieces.id)
    val date = datetime("cart_date")
    val qty = integer("quantity")
    val totalPrice = double("total_price")
    val user = reference("user_id", Users.id)
}
