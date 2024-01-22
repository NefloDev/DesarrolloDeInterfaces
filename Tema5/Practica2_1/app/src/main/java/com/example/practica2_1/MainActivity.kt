package com.example.practica2_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica2_1.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.pager.adapter = SectionsPagerAdapter(this, supportFragmentManager, lifecycle)

        TabLayoutMediator(binding.tabs, binding.pager) { tab, position ->
            tab.text = "TAB ${position+1}"
        }.attach()
    }
}