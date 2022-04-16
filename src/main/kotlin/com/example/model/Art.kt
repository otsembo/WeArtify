package com.example.model

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
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
    val seller: Seller,
    val isActive: Boolean,
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
    val isActive = bool("is_active")
}

class ArtEntity(id:EntityID<Long>) : LongEntity(id){
    companion object : EntityClass<Long, ArtEntity>(ArtPieces)
    var art_category by ArtPieces.art_category
    var name by ArtPieces.name
    var desc by ArtPieces.desc
    var price by ArtPieces.price
    var displayPrice by ArtPieces.displayPrice
    var thumbnail by ArtPieces.thumbnail
    var banner by ArtPieces.banner
    var stock by ArtPieces.stock
    var tmpStock by ArtPieces.tmpStock
    var refundPolicy by ArtPieces.refundPolicy
    var paymentPolicy by ArtPieces.paymentPolicy
    var seller by ArtPieces.seller
    var isActive by ArtPieces.isActive
}

fun ArtEntity.getArt() : Art{
    return Art(
        id.value, ArtCategoryEntity[art_category].getArtCategory(), name, desc,
        price, displayPrice, ArtImageEntity[thumbnail].getArtImage(), ArtImageEntity[banner].getArtImage(),
        stock, tmpStock, refundPolicy, paymentPolicy, "", SellersEntity[seller].getSeller(), isActive
    )
}
