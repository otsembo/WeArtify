package com.example.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
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

class CartEntity(id:EntityID<Long>) : LongEntity(id){
    companion object : EntityClass<Long, CartEntity>(Carts)

    var status by Carts.status
    var art by Carts.art
    var date by Carts.date
    var qty by Carts.qty
    var totalPrice by Carts.totalPrice
    var user by Carts.user

}

fun CartEntity.getCartItem() : Cart{
    return Cart(
        id = id.value,
        status = CartStatusEntity[status].getStatus(),
        item = ArtEntity[art].getArt(),
        date = date.toLocalDate().toString(),
        qty = qty,
        totalPrice = totalPrice,
        user = UserEntity[user].getUser(),
    )
}
