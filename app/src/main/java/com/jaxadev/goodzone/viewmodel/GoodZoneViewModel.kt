package com.jaxadev.goodzone.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jaxadev.goodzone.model.Banner
import com.jaxadev.goodzone.repository.GoodZoneRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GoodZoneViewModel : ViewModel() {

    val job = Job()
    val viewModelScope = CoroutineScope(Dispatchers.Main + job)

    val repository = GoodZoneRepository()

    var bannersLiveData = MutableLiveData<ArrayList<Banner>>()

    init {
        fetchBanners()
    }

    private fun fetchBanners() {
        viewModelScope.launch {
            bannersLiveData.value = repository.fetchBanners().value
        }

    }


    companion object {
        class Factory : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                if (modelClass == GoodZoneViewModel::class.java) {
                    return GoodZoneViewModel() as T
                }
                throw IllegalArgumentException("This factory takes only GoodZoneViewModel class")
            }
        }
    }
}