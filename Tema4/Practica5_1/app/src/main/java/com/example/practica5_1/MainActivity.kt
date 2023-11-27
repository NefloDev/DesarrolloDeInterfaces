package com.example.practica5_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.example.practica5_1.adapters.ImageAdapter
import com.example.practica5_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){
    private lateinit var binding : ActivityMainBinding
    private val imageList = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4,
        R.drawable.image5,
        R.drawable.image6,
        R.drawable.image7,
        R.drawable.image8,
        R.drawable.image9,
        R.drawable.image10)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var currentPosition = -1

        binding.imageSwitcher.setFactory { AppCompatImageView(applicationContext) }

        val adapter = ImageAdapter(imageList)

        adapter.setOnItemClickListener(object : ImageAdapter.OnItemClickListener{
            override fun OnItemClick(view: View, position: Int) {
                binding.imageSwitcher.setInAnimation(this@MainActivity,R.anim.from_left)
                binding.imageSwitcher.setOutAnimation(this@MainActivity,R.anim.to_right)
                if(currentPosition != position) {
                    binding.imageSwitcher.setImageResource(imageList[position])
                    currentPosition = position
                }
            }
        })

        binding.imageRecyclerView.adapter = adapter
    }

}