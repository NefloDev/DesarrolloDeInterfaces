package com.example.practica4;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
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
        EditText phone = findViewById(R.id.editPhone);

        ArrayAdapter<String> adapter =  new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, peliculas);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        listPeliculas.setAdapter(adapter);

        listPeliculas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                phone.setText(listPeliculas.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
}