package com.jaxadev.goodzone.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jaxadev.goodzone.model.BannerModel
import com.jaxadev.goodzone.model.PromoModel
import com.jaxadev.goodzone.repository.GoodZoneRepository
import com.jaxadev.goodzone.utils.Resource
import kotlinx.coroutines.launch

class GoodZoneViewModel(private val repository: GoodZoneRepository) : ViewModel() {

    val bannerLiveData = MutableLiveData<Resource<BannerModel>>()
    val promoLiveData = MutableLiveData<Resource<PromoModel>>()

    init {
        fetchBanners()
        fetchPromos()
    }

    private fun fetchPromos() {
        viewModelScope.launch {
            val promos = repository.getPromos()
            if (promos.isSuccessful) {
                promoLiveData.value = Resource.success(promos.body())
            } else {
                promoLiveData.value =
                    Resource.error(promos.errorBody()?.string() ?: "Empty Promo", null)
            }
        }
    }

    private fun fetchBanners() {
        viewModelScope.launch {
            val banners = repository.getBanners()
            if (banners.isSuccessful) {
                bannerLiveData.value = Resource.success(banners.body())
            } else {
                bannerLiveData.postValue(
                    Resource.error(
                        banners.errorBody()?.string() ?: "Empty Banner",
                        null
                    )
                )
            }
        }
    }

    fun getBanners(): LiveData<Resource<BannerModel>> = bannerLiveData
    fun getPromos(): LiveData<Resource<PromoModel>> = promoLiveData

}