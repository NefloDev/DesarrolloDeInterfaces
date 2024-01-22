package com.example.practica2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.practica2.databinding.ActivityMainBinding
import com.example.practica2.fragments.TabFragment1
import com.example.practica2.fragments.TabFragment2
import com.example.practica2.fragments.TabFragment3
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = object : FragmentStateAdapter(this@MainActivity){
            override fun getItemCount(): Int {
                return 3
            }

            override fun createFragment(position: Int): Fragment {
                return when(position){
                    0 -> TabFragment1()
                    1 -> TabFragment2()
                    2 -> TabFragment3()
                    else -> TabFragment1()
                }
            }
        }

        TabLayoutMediator(binding.tabLayout, binding.viewPager){tab, position ->
            tab.text = when(position){
                0 -> "Tab 1"
                1 -> "Tab 2"
                2 -> "Tab 3"
                else -> "Tab 1"
            }
        }.attach()

    }
}