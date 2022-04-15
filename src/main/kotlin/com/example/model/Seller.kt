package com.example.model

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
