package com.example.practica4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.practica4.Entities.GenerosAdapter;
import com.example.practica4.Entities.GenerosViewHolder;
import com.google.android.material.chip.Chip;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class Filter extends AppCompatActivity {

    private final List<String> genres = List.of("Acción", "Aventura", "Deportes", "Disparos", "Estrategia", "Lucha", "Musical", "Rol", "Simulación");
    private RecyclerView listView;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_layout);

        listView = findViewById(R.id.listView);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(v -> {
            Snackbar a = Snackbar.make(v, "El botón se desplaza hacia arriba", Snackbar.LENGTH_SHORT);
            a.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE);
            a.show();
        });

        GenerosAdapter adapter = new GenerosAdapter(genres, this);
        listView.setLayoutManager(new LinearLayoutManager(this));

        listView.setAdapter(adapter);
    }

    public void showChip(View view){
        Chip chip = (Chip) view;

        Toast.makeText(this, chip.getText().toString(), Toast.LENGTH_SHORT).show();
    }

}