package com.example.domain.model

import com.example.model.ArtCategory
import com.example.model.HomeBanner

@kotlinx.serialization.Serializable
data class ApiResponse<T>(
    val status:Int,
    val message:String,
    val data:T?
)

@kotlinx.serialization.Serializable
data class HomePageResponse(
    val activeBanners:List<HomeBanner>,
    val artCategories:List<ArtCategory>,
)
