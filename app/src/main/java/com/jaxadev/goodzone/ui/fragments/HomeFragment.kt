package com.jaxadev.goodzone.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jaxadev.goodzone.databinding.FragmentHomeBinding
import com.jaxadev.goodzone.model.DiscountItem
import com.jaxadev.goodzone.ui.adapter.DiscountRecyclerView
import com.jaxadev.goodzone.ui.adapter.SliderAdapter
import com.jaxadev.goodzone.viewmodel.GoodZoneViewModel
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations


class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding

    val goodZoneViewModel = GoodZoneViewModel()

    private lateinit var discountRecyclerView: DiscountRecyclerView
    private lateinit var discounts: ArrayList<DiscountItem>


    var images = arrayListOf(
        "https://cdn.goodzone.uz/goodzone/e46df6e0-39c0-4b06-a6d1-15edf316d6cc",
        "https://cdn.goodzone.uz/goodzone/12836605-9a03-47b5-925d-5ccbdd4efcad",
        "https://cdn.goodzone.uz/goodzone/480dd0d1-f2e3-4e65-8e8e-d3ca2f86b94b",
        "https://cdn.goodzone.uz/goodzone/1fe1b8e5-8f28-4020-8711-dbd31c9ae056"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        goodZoneViewModel.fetchBanners()

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

        binding.imageSlider.apply {
            setSliderAdapter(sliderAdapter)
            setIndicatorAnimation(IndicatorAnimationType.WORM)
            setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION)
            startAutoCycle()
        }

        discountRecyclerView = DiscountRecyclerView(
            itemDiscountCallBack = DiscountRecyclerView.ItemDiscountCallBack { discountItem ->
            }
        )

        for (i in 0..10) {
            discounts.add(
                DiscountItem(
                    "https://i2.wp.com/www.iedunote.com/img/1061/discount.png?resize=301%2C169&quality=100&ssl=1",
                    "eng yaxshi narsalar faqat siz uchun"
                )
            )
        }



        discountRecyclerView.submitList(discounts)

        binding.rvDiscount.apply {

            layoutManager =
                LinearLayoutManager(requireActivity(), LinearLayoutManager.HORIZONTAL, false)
            adapter = discountRecyclerView

        }

    }


}