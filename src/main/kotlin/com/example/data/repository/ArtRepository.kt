package com.example.data.repository

import com.example.model.Art
import com.example.model.ArtEntity
import com.example.model.ArtPieces
import com.example.model.getArt
import org.jetbrains.exposed.sql.SortOrder
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.transactions.transaction

class ArtRepository {

    private lateinit var artList:ArrayList<Art>

    private fun initList(){
        artList = ArrayList()
    }

    fun getLatestArt(limit: Int) : List<Art>{

        initList()

        transaction {
            ArtEntity.find { (ArtPieces.isActive eq true)  and (ArtPieces.stock greater 0)  }
                .limit(limit)
                .orderBy(ArtPieces.dateAdded to SortOrder.DESC_NULLS_LAST)
                .forEach {
                    artList.add(
                        it.getArt()
                    )
            }
            commit()
        }
        return artList
    }


    fun getArt(page:Int, limit:Int) : List<Art>{

        initList()

        transaction {
            ArtEntity.find { (ArtPieces.isActive eq true)  and (ArtPieces.stock greater 0)  }
                .limit(offset = ((page - 1) * limit).toLong(), n = limit)
                .orderBy(ArtPieces.dateAdded to SortOrder.DESC_NULLS_LAST)
                .forEach {
                    artList.add(
                        it.getArt()
                    )
            }
            commit()
        }
        return artList
    }

}