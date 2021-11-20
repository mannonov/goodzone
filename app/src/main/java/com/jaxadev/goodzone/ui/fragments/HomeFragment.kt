package com.jaxadev.goodzone.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaxadev.goodzone.databinding.FragmentHomeBinding
import com.jaxadev.goodzone.model.DiscountItem
import com.jaxadev.goodzone.network.ApiClient
import com.jaxadev.goodzone.repository.GoodZoneRepository
import com.jaxadev.goodzone.ui.adapter.DiscountRecyclerViewAdapter
import com.jaxadev.goodzone.ui.adapter.SliderAdapter
import com.jaxadev.goodzone.utils.Status.*
import com.jaxadev.goodzone.viewmodel.GoodZoneViewModel
import com.jaxadev.goodzone.viewmodel.factory.GoodZoneViewModelFactory
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations


class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding

    private lateinit var goodZoneViewModel: GoodZoneViewModel

    private lateinit var discountRecyclerViewAdapter: DiscountRecyclerViewAdapter
    private lateinit var discounts: ArrayList<DiscountItem>


    var images = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val repository = GoodZoneRepository(ApiClient.getApiService())
        goodZoneViewModel = ViewModelProvider(
            this,
            GoodZoneViewModelFactory(repository)
        )[GoodZoneViewModel::class.java]

        discounts = ArrayList()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return _binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sliderAdapter = SliderAdapter(images)


        goodZoneViewModel.getBanners().observe(requireActivity(), Observer {

            when (it.status) {
                LOADING -> Toast.makeText(requireActivity(), "Loading", Toast.LENGTH_SHORT).show()
                ERROR -> Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
                SUCCESS -> {
                    Toast.makeText(requireActivity(), "Success", Toast.LENGTH_SHORT).show()
                    it.data?.banners?.map {
                        it.image
                    }?.toList()?.let { it1 -> images.addAll(it1) }
                    sliderAdapter.notifyDataSetChanged()

                }
            }

        })

        binding.imageSlider.apply {
            setSliderAdapter(sliderAdapter)
            setIndicatorAnimation(IndicatorAnimationType.WORM)
            setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
            startAutoCycle()
        }

        discountRecyclerViewAdapter = DiscountRecyclerViewAdapter(
            itemDiscountCallBack = DiscountRecyclerViewAdapter.ItemDiscountCallBack { discountItem ->
                Toast.makeText(requireActivity(), discountItem.text, Toast.LENGTH_SHORT).show()
            }
        )

        goodZoneViewModel.getPromos().observe(requireActivity(), Observer {

            when (it.status) {
                LOADING -> Toast.makeText(requireActivity(), "Loading", Toast.LENGTH_SHORT).show()
                ERROR -> Toast.makeText(requireActivity(), "Error", Toast.LENGTH_SHORT).show()
                SUCCESS -> {
                    for (promo in it.data?.promos!!) {
                        discounts.add(DiscountItem(promo.preview_image, promo.title))
                    }
                    discountRecyclerViewAdapter.notifyDataSetChanged()
                }
            }

        })

        discountRecyclerViewAdapter.submitList(discounts)

        binding.rvDiscount.apply {

            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = discountRecyclerViewAdapter

        }

    }


}