package com.example.model

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class ArtCategory(
    val id:Long,
    val name:String,
)

object ArtCategories : LongIdTable("art_category"){
    val name = varchar("name", 255)
}
