package com.example.model.objects

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
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

class CartStatusEntity(id:EntityID<Long>) : LongEntity(id){
    companion object : EntityClass<Long, CartStatusEntity>(CartStatuses)
    var type by CartStatuses.type
}

fun CartStatusEntity.getStatus() : CartStatus{
    return CartStatus(
        id = id.value,
        type = type
    )
}