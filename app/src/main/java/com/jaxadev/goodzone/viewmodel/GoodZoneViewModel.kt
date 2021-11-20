package com.jaxadev.goodzone.viewmodel

import android.widget.Toast
import androidx.lifecycle.*
import com.jaxadev.goodzone.model.ModelClass
import com.jaxadev.goodzone.repository.GoodZoneRepository
import com.jaxadev.goodzone.utils.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import timber.log.Timber

class GoodZoneViewModel(private val repository: GoodZoneRepository) : ViewModel() {

    val liveData = MutableLiveData<Resource<List<ModelClass>>>()

    init {
        fetchBanners()
    }

    private fun fetchBanners() {
        viewModelScope.launch {
            val banners = repository.getBanners()
            if (banners.isSuccessful) {
                liveData.postValue(Resource.success(banners.body()))
            } else {
                liveData.postValue(Resource.error(banners.errorBody()?.string() ?: "Empty", null))
            }
        }
    }

    fun getBanners(): LiveData<Resource<List<ModelClass>>> = liveData

}