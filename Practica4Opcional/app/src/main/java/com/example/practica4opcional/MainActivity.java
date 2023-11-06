package com.example.practica4opcional;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.practica4opcional.Entities.SportAdapter;
import com.example.practica4opcional.Entities.SportViewHolder;

import java.util.List;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private final List<String> names = List.of("Baloncesto", "Beisbol", "Ciclismo", "Fútbol", "Golf", "Hipica", "Natacion", "PinPon", "Tenis");
    private final List<Integer> images = List.of(
            R.mipmap.baloncesto_foreground,
            R.mipmap.beisbol_foreground,
            R.mipmap.ciclismo_foreground,
            R.mipmap.futbol_foreground,
            R.mipmap.golf_foreground,
            R.mipmap.hipica_foreground,
            R.mipmap.natacion_foreground,
            R.mipmap.pinpon_foreground,
            R.mipmap.tenis_foreground);

    private RecyclerView recyclerView;
    private SportAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new SportAdapter(names, images);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void showSelectedCheckBoxes(View view){
        int last;
        String text;
        List<String> selected = adapter.getViewHolderList().stream()
                .filter(v -> v.getCheckBox().isChecked())
                .map(v -> v.getCheckBox().getText().toString()).collect(Collectors.toList());
        last = selected.size()-1;

        if (selected.size()>0){
            text = "Has seleccionado: ";
            if(selected.size()==1) text += selected.get(0);
            else text += String.join(" y ", String.join(", ", selected.subList(0, last)), selected.get(last));
        }else {
            text = "No has seleccionado nada";
        }

        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }
}