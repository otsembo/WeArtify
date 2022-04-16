package com.example.model

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class ArtImage(
    val id:Long,
    val url:String,
    val types: ImageTypes,
)

object ArtImages : LongIdTable("art_images"){
    val url = text("url",)
    val types = reference("image_types", ImageType.id)
}

class ArtImageEntity(id:EntityID<Long>) : LongEntity(id){
    companion object:EntityClass<Long, ArtImageEntity>(ArtImages)
    var url by ArtImages.url
    var types by ArtImages.types
}
