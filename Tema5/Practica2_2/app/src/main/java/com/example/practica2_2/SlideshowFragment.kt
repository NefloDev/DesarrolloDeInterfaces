package com.example.practica2_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practica2_2.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        return (FragmentSlideshowBinding.inflate(inflater, container, false)).root
    }
}