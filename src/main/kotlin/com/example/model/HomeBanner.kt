package com.example.model

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class HomeBanner(
    val id:Long,
    val imageUrl:String,
    val isActive:Boolean,
    val quote:String,
    val description:String,
)

object HomeBanners : LongIdTable("home_banners"){
    val imageUrl = text("image_url")
    val isActive = bool("is_active")
    val quote = varchar("quote", 255)
    val description = text("description")
}

class HomeBannerEntity(id:EntityID<Long>) : LongEntity(id){
    companion object : EntityClass<Long, HomeBannerEntity>(HomeBanners)
    var imageUrl by HomeBanners.imageUrl
    var isActive by HomeBanners.isActive
    var quote by HomeBanners.quote
    var description by HomeBanners.description
}
