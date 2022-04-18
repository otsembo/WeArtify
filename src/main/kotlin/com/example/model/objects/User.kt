package com.example.model.objects

import org.jetbrains.exposed.dao.EntityClass
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
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

object Users : LongIdTable("users"){
    val name = text("full_name")
    val email = text("email_address").uniqueIndex()
    val password = text("password")
    val approved = bool("is_approved")
    val phone = varchar("phone_number", 15).uniqueIndex()
    val roleId = reference("role_id", Roles.id)
    val profileImage = varchar("profile_img", 255)
    val dateRegistered = datetime("date_registered")
    val dateLastLoggedIn = datetime("date_last_logged_in")
}

class UserEntity(id:EntityID<Long>) : LongEntity(id){
    companion object: EntityClass<Long, UserEntity>(Users)

    var name by Users.name
    var email by Users.email
    var password by Users.password
    var approved by Users.approved
    var phone by Users.phone
    var roleId by Users.roleId
    var profileImage by Users.profileImage
    var dateRegistered by Users.dateRegistered
    var dateLastLoggedIn by Users.dateLastLoggedIn

}

fun UserEntity.getUser(): User{
    return User(
        id.value, name, email, password, approved, phone,
        RoleEntity[roleId].getRole(), profileImage, dateRegistered.toString(), dateLastLoggedIn.toString()
    )
}
