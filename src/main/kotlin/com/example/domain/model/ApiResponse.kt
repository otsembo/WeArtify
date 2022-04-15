package com.example.domain.model

@kotlinx.serialization.Serializable
data class ApiResponse<T>(
    val status:Int,
    val message:String,
    val data:T?
)
