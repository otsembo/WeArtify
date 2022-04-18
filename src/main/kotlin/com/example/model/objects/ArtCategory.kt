package com.example.model.objects

import org.jetbrains.exposed.dao.Entity
import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
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

class ArtCategoryEntity(id: EntityID<Long>) : LongEntity(id){
    companion object : EntityClass<Long, ArtCategoryEntity>(ArtCategories)
    var name by ArtCategories.name
}

fun ArtCategoryEntity.getArtCategory() : ArtCategory{
    return ArtCategory(
        id.value, name
    )
}
