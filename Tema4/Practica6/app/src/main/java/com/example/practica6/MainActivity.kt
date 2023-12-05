package com.example.practica6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practica6.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ActivityMainBinding.inflate(layoutInflater).root)
    }
}