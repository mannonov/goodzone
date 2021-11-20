package com.jaxadev.goodzone.network

import com.jaxadev.goodzone.model.BannerModel
import com.jaxadev.goodzone.model.PromoModel
import retrofit2.Response
import retrofit2.http.GET

interface GoodZoneService {

    @GET("/v1/banner")
    suspend fun getBanners(): Response<BannerModel>

    @GET("/v1/promo")
    suspend fun getPromos(): Response<PromoModel>

}

