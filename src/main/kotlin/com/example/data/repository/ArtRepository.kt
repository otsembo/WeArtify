package com.example.data.repository

import com.example.model.Art
import com.example.model.ArtEntity
import com.example.model.ArtPieces
import com.example.model.getArt
import org.jetbrains.exposed.sql.SqlExpressionBuilder.greater
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class ArtRepository {

    fun getLatestArt() : List<Art>{
        val artList =  ArrayList<Art>()
        transaction {
            ArtEntity.find { (ArtPieces.isActive eq true)  and (ArtPieces.stock greater 0)  }.limit(5).forEach {
                artList.add(
                    it.getArt()
                )
            }
            commit()
        }
        return artList
    }

}