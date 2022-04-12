package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class CartStatus (
    val id:Long,
    val type:String,
)