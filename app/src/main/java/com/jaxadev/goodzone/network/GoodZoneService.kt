package com.jaxadev.goodzone.network

import com.jaxadev.goodzone.model.ModelClass
import retrofit2.Response
import retrofit2.http.GET

interface GoodZoneService {

    @GET("/v1/banner")
    suspend fun getBanners(): Response<List<ModelClass>>

}

