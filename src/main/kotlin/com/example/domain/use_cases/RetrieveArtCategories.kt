package com.example.domain.use_cases

import com.example.model.objects.*
import org.jetbrains.exposed.sql.transactions.transaction

object RetrieveArtCategories {

    fun fetchCategories() : List<ArtCategory>{
        val categories = ArrayList<ArtCategory>()

        transaction {
            ArtCategoryEntity.all().forEach {
                categories.add(
                    with(it){
                        ArtCategory(id.value, name)
                    }
                )
            }
            commit()
        }

        return categories
    }

}