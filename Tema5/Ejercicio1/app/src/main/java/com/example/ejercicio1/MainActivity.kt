package com.example.ejercicio1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.ejercicio1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.tulbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        val spinnerList = this.resources.getStringArray(R.array.spinnerArray)

        val spinner = (binding.navigationView.getHeaderView(0) as LinearLayout).findViewById<Spinner>(R.id.spinner)
        val adapter =
            ArrayAdapter<String>(this, R.layout.spinner_custom_element, spinnerList)
        adapter.setDropDownViewResource(R.layout.spinner_inner_custom_element)
        spinner.adapter = adapter

        val appBarConfig =
            AppBarConfiguration.Builder(
                R.id.inboxFragment, R.id.outboxFragment, R.id.trashFragment, R.id.spamFragment)
                .setOpenableLayout(binding.drawerLayout).build()
        val navController =
            (supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment).navController
        NavigationUI.setupWithNavController(binding.navigationView, navController)
        NavigationUI.setupWithNavController(binding.tulbar, navController, appBarConfig)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.empty_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}