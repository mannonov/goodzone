package com.jaxadev.goodzone.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.jaxadev.goodzone.model.Banner
import com.jaxadev.goodzone.service.GoodZoneApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class GoodZoneRepository(){

    suspend fun fetchBanners(): LiveData<ArrayList<Banner>> {
        return withContext(Dispatchers.IO) {
            val slowResultOfBanners = GoodZoneApi.goodZoneService.getInfo().await()
            return@withContext liveData {
                emit(slowResultOfBanners)
            }
        }
    }

}