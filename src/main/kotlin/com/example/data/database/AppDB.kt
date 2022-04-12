package com.example.data.database

import com.example.model.ArtCategories
import com.example.model.Roles
import com.example.model.Users
import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import io.ktor.application.*
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

fun Application.configureDB(){
    Database.connect(DbProperties.connect())
    transaction {
        SchemaUtils.create(Roles, Users, ArtCategories)
        commit()
    }
}

object DbProperties{
    private const val dbURL = "jdbc:mysql://localhost:3306/weartify"
    fun connect() : DataSource{
        val config = HikariConfig()
        config.jdbcUrl = dbURL
        config.username = "root"
        config.password = ""
        config.driverClassName = "com.mysql.jdbc.Driver"
        config.isAutoCommit = false
        return HikariDataSource(config)
    }

}