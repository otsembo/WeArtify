package com.example.model

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class ImageTypes(
    val id:Long,
    val type:String,
)

object ImageType : LongIdTable("image_types"){
    val type = varchar("type", 255)
}
