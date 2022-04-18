package com.example.data.repository

import com.example.model.objects.*
import org.jetbrains.exposed.sql.transactions.transaction

class RoleRepository() {

    fun getRoles(): HashMap<String,List<Role>> {
        //create roles array list
        val roles = ArrayList<Role>()

        transaction {
            RoleEntity.all().forEach {
                roles.add(
                    Role(it.id.value, it.name)
                )
            }
            commit()
        }

        val rolesResponse = HashMap<String, List<Role>>()
        rolesResponse["roles"] = roles

        return (rolesResponse)
    }

    fun getRoleById(id:Long) : HashMap<String, Role?>{
        var role:Role? = null
        transaction {

            RoleEntity.findById(id)?.let {
                role = Role(it.id.value, it.name)
            }

            commit()
        }

        val roleResponse = HashMap<String, Role?>()
        roleResponse["role"] = role

        return roleResponse
    }

}