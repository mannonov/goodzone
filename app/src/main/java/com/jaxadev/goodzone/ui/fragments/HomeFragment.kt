package com.jaxadev.goodzone.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jaxadev.goodzone.R
import com.jaxadev.goodzone.viewmodel.GoodZoneViewModel
import timber.log.Timber


class HomeFragment : Fragment() {

    private lateinit var goodZoneViewModel: GoodZoneViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        goodZoneViewModel = createMainViewModel()

        Timber.d("banners = ${goodZoneViewModel.bannersLiveData.value}")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    fun createMainViewModel(): GoodZoneViewModel {
        val mainFactory = GoodZoneViewModel.Companion.Factory()
        return ViewModelProvider(this, mainFactory).get(GoodZoneViewModel::class.java)
    }


}