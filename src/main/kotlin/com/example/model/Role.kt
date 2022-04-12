package com.example.model

import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.Table

@Serializable
data class Role(
    val id:Long,
    val name:String
)

object Roles : Table("roles"){
    val roleId = integer("id").autoIncrement()
    val name = text("name")
    override val primaryKey: PrimaryKey = PrimaryKey(roleId,)
}
