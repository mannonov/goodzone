package com.jaxadev.goodzone.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jaxadev.goodzone.model.ModelClass
import com.jaxadev.goodzone.service.GoodZoneApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class GoodZoneRepository() {

    val banners = MutableLiveData<ModelClass>()

    suspend fun getInfoBanners(){

        return withContext(Dispatchers.IO) {

            GoodZoneApi.goodZoneService.getInfo().enqueue(object : Callback<ModelClass> {
                override fun onResponse(call: Call<ModelClass>, response: Response<ModelClass>) {
                    banners.value = response.body()
                    Timber.d("${response.body()}")
                    Log.d("ResponseBody", "onResponse: ${response.body()}")
                }

                override fun onFailure(call: Call<ModelClass>, t: Throwable) {

                }
            })

            }
        }
    }

