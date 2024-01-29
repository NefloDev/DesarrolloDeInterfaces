package com.example.practica2_2

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.practica2_2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

/**
 * MainActivity represents the principal activity using ViewPager2 and TabLayout to navigate
 * through Fragments
 * @author Alejandro Nebot Flores
 * @version 2024-01-29
 */

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        binding.toolbar.navigationIcon?.setTint(Color.WHITE)

        binding.pager.setPageTransformer(CustomPageTransformer())

        binding.pager.adapter = object : FragmentStateAdapter(this@MainActivity){
            override fun getItemCount(): Int {
                return 3
            }
            override fun createFragment(position: Int): Fragment {
                return when (position) {
                    0 -> HomeFragment()
                    1 -> GalleryFragment()
                    2 -> SlideshowFragment()
                    else -> HomeFragment()
                }
            }
        }

        TabLayoutMediator(binding.tabLayout, binding.pager){ tab, position ->
            tab.text = when(position){
                0 -> "Home"
                1 -> "Gallery"
                2 -> "Slideshow"
                else -> "Undefined"
            }
        }.attach()
    }
}