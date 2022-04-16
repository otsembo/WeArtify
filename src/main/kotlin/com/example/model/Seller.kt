package com.example.model

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class Seller(
    val id:Long,
    val user:User,
    val location:String,
    val activePhone:String,
    val sellerEmails:String,
)

object Sellers : LongIdTable("sellers"){
    val userId = reference("user_id", Users.id).uniqueIndex()
    val location = varchar("location", 255)
    val activePhone = varchar("active_phone", 15)
    val sellerEmail = varchar("seller_email", 255)
}

class SellersEntity(id:EntityID<Long>) : LongEntity(id){
    companion object : EntityClass<Long, SellersEntity>(Sellers)

    var userId by Sellers.id
    var location by Sellers.location
    var activePhone by Sellers.activePhone
    var sellerEmail by Sellers.sellerEmail
}

fun SellersEntity.getSeller() : Seller{
    return Seller(
        userId.value, UserEntity[userId].getUser(), location, activePhone, sellerEmail
    )
}
