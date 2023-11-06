package com.example.practica4;

import android.os.Bundle;

import com.example.practica4.Entities.AboutAdapter;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.core.view.WindowCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica4.databinding.ActivityAboutBinding;

import java.util.List;

public class About extends AppCompatActivity {

    private final List<Integer> images = List.of(
            R.mipmap.image1_foreground,
            R.mipmap.image2_foreground,
            R.mipmap.image3_foreground,
            R.mipmap.image4_foreground,
            R.mipmap.image5_foreground,
            R.mipmap.image6_foreground,
            R.mipmap.image7_foreground,
            R.mipmap.image8_foreground
    );

    private final List<String> names = List.of("María Mata", "Antonio Sanz", "Carlos", "Berta", "Héctor Campos", "Ismael", "Juan Carlos", "Isabel");
    private final List<String> years = List.of("2014", "1890", "967", "945", "879", "678", "669", "420");

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        recyclerView = findViewById(R.id.recyclerView);

        AboutAdapter adapter = new AboutAdapter(images, names, years, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }
}