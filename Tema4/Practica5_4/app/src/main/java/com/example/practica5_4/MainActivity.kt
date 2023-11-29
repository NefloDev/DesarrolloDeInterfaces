package com.example.practica5_4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practica5_4.adapter.RestaurantAdapter
import com.example.practica5_4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val images = listOf(
            R.drawable.images,
            R.drawable.images1,
            R.drawable.images2,
            R.drawable.images3,
            R.drawable.images4,
            R.drawable.images5,
            R.drawable.images6
        )

        val names = listOf(
            "Restaurant 1",
            "Restaurant 2",
            "Restaurant 3",
            "Restaurant 4",
            "Restaurant 5",
            "Restaurant 6",
            "Restaurant 7"
        )

        val locations = listOf(
            "Location 1",
            "Location 2",
            "Location 3",
            "Location 4",
            "Location 5",
            "Location 6",
            "Location 7"
        )

        val ratings = listOf(1f, 2f, 3f, 3.5f, 4f, 4.5f, 5f)

        binding.recycler.adapter = RestaurantAdapter(names, locations, images, ratings)
        binding.recycler.layoutManager = LinearLayoutManager(this)

    }
}