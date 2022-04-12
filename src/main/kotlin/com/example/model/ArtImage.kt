package com.example.model

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class ArtImage(
    val id:Long,
    val url:String,
    val types: ImageTypes,
)

object ArtImages : Table("art_images"){
    val id = long("id").autoIncrement()
    val url = text("url",)
    val types = reference("image_types", ImageType.id)
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(id)
}
