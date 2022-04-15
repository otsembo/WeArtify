package com.example.model

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class HomeBanner(
    val id:Long,
    val imageUrl:String,
    val isActive:Boolean,
)

object HomeBanners : LongIdTable("home_banners"){
    val imageUrl = text("image_url")
    val isActive = bool("is_active")
}
