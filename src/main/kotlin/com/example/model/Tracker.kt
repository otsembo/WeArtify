package com.example.model

@kotlinx.serialization.Serializable
data class Tracker(
    val id:Long,
    val order: Order,
    val status: TrackerStatus,
    val pickUp:String,
    val dropOff:String,
)

enum class TrackerStatus{
    NULL, SHIPPED, DELIVERED, PROCESSING
}
