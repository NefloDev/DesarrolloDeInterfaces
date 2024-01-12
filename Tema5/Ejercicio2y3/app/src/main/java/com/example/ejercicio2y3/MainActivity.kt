package com.example.ejercicio2y3

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.ejercicio2y3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.materialToolbar)
        this.title = "Home"

        val appBarConfiguration =
            AppBarConfiguration.Builder(
                R.id.homeFragment, R.id.galleryFragment, R.id.slideshowFragment)
                .setOpenableLayout(binding.drawerLayout).build()

        val navController =
            (supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment).navController

        NavigationUI.setupWithNavController(binding.navigationView, navController)
        NavigationUI.setupWithNavController(binding.materialToolbar, navController, appBarConfiguration)

        binding.materialToolbar.navigationIcon?.setTint(Color.WHITE)
    }
}