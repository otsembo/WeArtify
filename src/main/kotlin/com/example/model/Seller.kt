package com.example.model

@kotlinx.serialization.Serializable
data class Seller(
    val userId:Long,
    val location:String,
    val activePhone:String,
    val sellerEmails:String,
)
