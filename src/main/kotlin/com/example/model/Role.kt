package com.example.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

@Serializable
data class Role(
    val id:Long,
    val name:String
)

object Roles : LongIdTable("roles"){
    val name = text("name")
}

class RoleEntity(id: EntityID<Long>) : Entity<Long>(id){
    companion object : EntityClass<Long, RoleEntity>(Roles)
    var name by Roles.id

}
