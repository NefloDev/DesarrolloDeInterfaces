package com.example.practica5_2

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.practica5_2.databinding.ActivityComparaPlanetasBinding
import com.example.practica5_2.entities.Planet

class ComparaPlanetas : AppCompatActivity() {

    private lateinit var binding: ActivityComparaPlanetasBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComparaPlanetasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val list = listOf(
            Planet("Mercurio", "0.382", "0.387", "5400"),
            Planet("Venus", "0.949", "0.723", "5250"),
            Planet("Tierra", "1", "1", "5520"),
            Planet("Marte", "0.53", "1.542", "3960"),
            Planet("Júpiter", "11.2", "5.203", "1350"),
            Planet("Saturno", "9.41", "9.539", "700"),
            Planet("Urano", "3.38", "19.81", "1200"),
            Planet("Neptuno", "3.81", "30.07", "1500"),
            Planet("Plutón", "???", "39.44", "5?")
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list.map { p -> p.name })

        binding.planeta1.setAdapter(adapter)
        binding.planeta2.setAdapter(adapter)

        binding.planeta1.setOnItemClickListener { _, _, _, _ ->
            binding.densidadPlan1.text = (list.find { p -> p.name == binding.planeta1.text.toString() })?.density
            binding.diametroPlan1.text = (list.find { p -> p.name == binding.planeta1.text.toString() })?.diameter
            binding.distanciaSolPlan1.text = (list.find { p -> p.name == binding.planeta1.text.toString() })?.distanceToSun
        }
        binding.planeta2.setOnItemClickListener { _, _, _, _ ->
            binding.densidadPlan2.text = (list.find { p -> p.name == binding.planeta2.text.toString() })?.density
            binding.diametroPlan2.text = (list.find { p -> p.name == binding.planeta2.text.toString() })?.diameter
            binding.distanciaSolPlan2.text = (list.find { p -> p.name == binding.planeta2.text.toString() })?.distanceToSun
        }

    }
}