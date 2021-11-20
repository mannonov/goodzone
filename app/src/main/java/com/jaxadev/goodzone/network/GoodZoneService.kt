package com.jaxadev.goodzone.network

import com.jaxadev.goodzone.model.BannerModel
import com.jaxadev.goodzone.model.ProductModel
import com.jaxadev.goodzone.model.PromoModel
import retrofit2.Response
import retrofit2.http.GET

interface GoodZoneService {

    @GET("banner")
    suspend fun getBanners(): Response<BannerModel>

    @GET("promo")
    suspend fun getPromos(): Response<PromoModel>

    @GET("product")
    suspend fun getProducts(): Response<ProductModel>

}

