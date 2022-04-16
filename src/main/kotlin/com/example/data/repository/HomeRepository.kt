package com.example.data.repository

import com.example.model.HomeBanner
import com.example.model.HomeBannerEntity
import com.example.model.HomeBanners
import org.jetbrains.exposed.sql.transactions.transaction

class HomeRepository {

    fun getActiveHomeBanners(): List<HomeBanner>{

        val banners = ArrayList<HomeBanner>()

        transaction {

            HomeBannerEntity.find { HomeBanners.isActive eq true }.forEach {
                banners.add(
                    with(it){
                        HomeBanner(id.value, imageUrl, isActive, quote, description)
                    }
                )
            }

            commit()

        }

        return banners
    }

    fun getBanners(): List<HomeBanner>{

        val banners = ArrayList<HomeBanner>()

        transaction {

            HomeBannerEntity.all().forEach {
                banners.add(
                    with(it){
                        HomeBanner(id.value, imageUrl, isActive, quote, description)
                    }
                )
            }

            commit()

        }

        return banners
    }

}