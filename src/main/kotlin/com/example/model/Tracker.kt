package com.example.model

import org.jetbrains.exposed.sql.Table

@kotlinx.serialization.Serializable
data class Tracker(
    val id:Long,
    val order: Order,
    val status: TrackerStatus,
    val pickUp:String,
    val dropOff:String,
)

enum class TrackerStatus(val status:String){
    NULL("null"), SHIPPED("shipped"), DELIVERED("delivered"), PROCESSING("processing")
}

object Trackers : Table("order_tracker"){
    val id = long("id").autoIncrement()
    val order = reference("order_id", Orders.id)
    val status = enumeration("status", TrackerStatus::class)
    val pickUp = text("pickup_point")
    val dropOff = text("drop_off")
    override val primaryKey: PrimaryKey?
        get() = PrimaryKey(id)
}
