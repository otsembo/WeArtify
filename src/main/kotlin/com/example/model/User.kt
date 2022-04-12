package com.example.model

import com.example.model.Role

@kotlinx.serialization.Serializable
data class User(
    val id:Long,
    val name:String? = null,
    val email:String,
    val password:String,
    val approved:Boolean = false,
    val phone:String? = null,
    val role: Role,
    val profileImage:String? = null,
    val dateRegistered:String? = null,
    val dateLastLoggedIn:String? = null,
)
