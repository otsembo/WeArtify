package com.example.data.repository

import com.example.model.*
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class AppRepository {

    val roleRepository = RoleRepository()

}