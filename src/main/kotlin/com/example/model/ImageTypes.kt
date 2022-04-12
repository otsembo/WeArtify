package com.example.model

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class ImageTypes(
    val id:Long,
    val type:String,
)

object ImageType : Table("image_types"){
    val id = long("id").autoIncrement()
    val type = varchar("type", 255)
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
