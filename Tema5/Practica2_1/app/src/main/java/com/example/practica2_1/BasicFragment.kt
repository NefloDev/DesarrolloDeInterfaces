package com.example.practica2_1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practica2_1.databinding.FragmentBasicBinding

class BasicFragment : Fragment() {
    private lateinit var binding: FragmentBasicBinding

    companion object{
        private val ARG_SECTION_NUMBER = "section_number"
        fun newInstance(sectionNumber : Int): BasicFragment{
            val fragment = BasicFragment()
            val args = Bundle()
            args.putInt(ARG_SECTION_NUMBER, sectionNumber)
            fragment.arguments = args
            return fragment
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentBasicBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (arguments != null && requireArguments().containsKey(ARG_SECTION_NUMBER)){
            val sectionNumber = requireArguments().getInt(ARG_SECTION_NUMBER)
            binding.titleText.text = "Fragment ${sectionNumber}"
        }
    }
}