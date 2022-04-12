package com.example.model

@kotlinx.serialization.Serializable
data class Art(
    val id:Long,
    val category: ArtCategory,
    val name:String,
    val desc:String,
    val price:Double,
    val displayPrice:Double,
    val thumbnail: ArtImage,
    val banner: ArtImage,
    val stock:Int,
    val tmpStock:Int,
    val refundPolicy:String,
    val paymentPolicy:String,
    val location:String,
    val seller: Seller
)
