package com.example.practica4;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class NewPlayer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);

        List<String> peliculas = List.of(
                "Teléfono 1",
                "Teléfono 2",
                "Teléfono 3",
                "Teléfono 4",
                "Teléfono 5",
                "Teléfono 6",
                "Teléfono 7",
                "Teléfono 8",
                "Teléfono 9",
                "Teléfono 10"
        );

        Spinner listPeliculas = findViewById(R.id.spinnerPhone);

        ArrayAdapter<String> adapter =  new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, peliculas);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        listPeliculas.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}