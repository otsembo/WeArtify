package com.example.data.repository

import com.example.model.HomeBanner
import com.example.model.HomeBanners
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class AppRepository {

    fun getBanners() : List<HomeBanner>?{

        var homeBanners:List<HomeBanner>? = null;

        val banners = HomeBanners.select {
            (HomeBanners.isActive eq true)
        }

        transaction {

        }

        return homeBanners

    }

}