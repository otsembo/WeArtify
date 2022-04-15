package com.example.data.repository

import com.example.model.Role
import com.example.model.RoleEntity
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

}