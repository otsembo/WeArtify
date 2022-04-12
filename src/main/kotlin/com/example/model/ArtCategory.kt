package com.example.model

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class ArtCategory(
    val id:Long,
    val name:String,
)

object ArtCategories : Table("art_category"){
    val id = long("id").autoIncrement()
    val name = varchar("name", 255)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
