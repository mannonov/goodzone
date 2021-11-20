package com.jaxadev.goodzone.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jaxadev.goodzone.repository.GoodZoneRepository
import com.jaxadev.goodzone.viewmodel.GoodZoneViewModel
import java.lang.IllegalArgumentException

class GoodZoneViewModelFactory(private val repository: GoodZoneRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(GoodZoneViewModel::class.java)) {
            return GoodZoneViewModel(repository) as T
        }

        throw IllegalArgumentException("This factory takes only GoodZoneViewModel class")

    }
}