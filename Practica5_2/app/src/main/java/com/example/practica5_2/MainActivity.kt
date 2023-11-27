package com.example.practica5_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.practica5_2.adapters.CardViewAdapter
import com.example.practica5_2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val imageList = arrayListOf(
        R.drawable.corona_solar,
        R.drawable.manchasolar,
        R.drawable.magnetosfera,
        R.drawable.filamentos,
        R.drawable.espiculas,
        R.drawable.erupcionsolar
    )
    private val titleList = arrayListOf("corona solar", "mancha solar", "magnetosfera", "filamentos", "espiculas", "erupcionsolar")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recycler.layoutManager = GridLayoutManager(this@MainActivity, 2)
        binding.recycler.adapter = CardViewAdapter(imageList, titleList)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent = Intent(this@MainActivity, ComparaPlanetas::class.java)
        startActivity(intent)
        return super.onOptionsItemSelected(item)
    }
}