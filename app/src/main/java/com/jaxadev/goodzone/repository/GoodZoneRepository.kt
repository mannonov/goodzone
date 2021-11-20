package com.jaxadev.goodzone.repository

import com.jaxadev.goodzone.network.GoodZoneService

class GoodZoneRepository(private val goodZoneService: GoodZoneService) {

    suspend fun getBanners() = goodZoneService.getBanners()

    suspend fun getPromos() = goodZoneService.getPromos()

    suspend fun getProducts() = goodZoneService.getProducts()

}


