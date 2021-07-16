package com.jaxadev.goodzone.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jaxadev.goodzone.model.ModelClass
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://dev.goodzone.uz"

interface GoodZoneService {
    @GET("/v1/banner")
    fun getInfo(): Call<ModelClass>
}

val retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(MoshiConverterFactory.create())
    .addCallAdapterFactory(CoroutineCallAdapterFactory())
    .build()


object GoodZoneApi {
    val goodZoneService: GoodZoneService by lazy {
        retrofit.create(GoodZoneService::class.java)
    }
}
