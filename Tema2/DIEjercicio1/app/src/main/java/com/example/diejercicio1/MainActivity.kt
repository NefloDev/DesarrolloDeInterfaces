package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.diejercicio1.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val player = findViewById(R.id.button2) as Button
        player.setOnClickListener{launchNewPlayer()}
    }

    fun launchNewPlayer(){
        val i = Intent(this, NewPlayer::class.java)
        startActivity(i)
    }
}

