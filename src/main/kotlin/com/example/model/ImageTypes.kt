package com.example.model

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

@kotlinx.serialization.Serializable
data class ImageTypes(
    val id:Long,
    val type:String,
)

object ImageType : LongIdTable("image_types"){
    val type = varchar("type", 255)
}

class ImageTypeEntity(id:EntityID<Long>) : LongEntity(id){
    companion object :EntityClass<Long, ImageTypeEntity>(ImageType)
    var type by ImageType.type
}
