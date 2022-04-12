package com.example.model

import com.example.model.Role
import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

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

object Users : Table("users"){
    val id = long("id").autoIncrement()
    val name = text("full_name")
    val email = text("email_address")
    val password = text("password")
    val approved = bool("is_approved")
    val phone = varchar("phone_number", 15)
    val roleId = reference("role_id", Roles.roleId)
    val profileImage = varchar("profile_img", 255)
    val dateRegistered = datetime("date_registered")
    val dateLastLoggedIn = datetime("date_last_logged_in")
    override val primaryKey: PrimaryKey = PrimaryKey(id)
}
