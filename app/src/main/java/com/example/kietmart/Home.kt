package com.example.kietmart


import SliderAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.kietmart.databinding.FragmentHomeBinding
import com.smarteist.autoimageslider.SliderView


class Home : Fragment() {
    private var _binding: FragmentHomeBinding? =null
    private val binding get() = _binding

    lateinit var imageUrl: ArrayList<String>

    // on below line we are creating
    // a variable for our slider view.
    lateinit var sliderView: SliderView

    // on below line we are creating
    // a variable for our slider adapter.
    lateinit var sliderAdapter: SliderAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding?.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sliderView=view.findViewById(R.id.imageSlider)
        imageUrl = ArrayList()

        // on below line we are adding data to our image url array list.
        val imageUrl = arrayListOf( R.drawable.images,
            R.drawable.download,
            R.drawable.download2
        )


        // on below line we are initializing our
        // slider adapter and adding our list to it.
        sliderAdapter = SliderAdapter(imageUrl)

        // on below line we are setting auto cycle direction
        // for our slider view from left to right.
        sliderView.autoCycleDirection = SliderView.LAYOUT_DIRECTION_LTR

        // on below line we are setting adapter for our slider.
        sliderView.setSliderAdapter(sliderAdapter)
        sliderView.scrollTimeInSec = 3

        // on below line we are setting auto cycle
        // to true to auto slide our items.
        sliderView.isAutoCycle = true

        // on below line we are calling start
        // auto cycle to start our cycle.
        sliderView.startAutoCycle()

    }





}