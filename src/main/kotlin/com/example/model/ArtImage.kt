package com.example.model

@kotlinx.serialization.Serializable
data class ArtImage(
    val id:Long,
    val url:String,
    val types: ImageTypes,
)
