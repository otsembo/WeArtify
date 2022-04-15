package com.example.model

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.Table

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

object ArtPieces : LongIdTable("art_pieces"){
    val art_category = reference("category", ArtCategories.id)
    val name = varchar("title", 255)
    val desc = text("description")
    val price = double("price")
    val displayPrice = double("display_price")
    val thumbnail = reference("thumbnail", ArtImages.id)
    val banner = reference("banner", ArtImages.id)
    val stock = integer("stock")
    val tmpStock = integer("tmp_stock")
    val refundPolicy = text("refund_policy")
    val paymentPolicy = text("payment_policy")
    val seller = reference("seller_id", Sellers.id)
}
