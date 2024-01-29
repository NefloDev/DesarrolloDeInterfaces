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

/**
 * MainActivity that represents the Main Activity containing a Recyclerview that shows a list of
 * sports
 * @see SportAdapter
 * @see SportViewHolder
 * @author Alejandro Nebot Fores
 * @version 2023-11-27
 */

public class MainActivity extends AppCompatActivity {

    /**
     * List of Strings containing the names of the sports that will be shown
     */
    private final List<String> names = List.of(
            "Baloncesto", "Beisbol", "Ciclismo",
            "Fútbol", "Golf", "Hipica",
            "Natacion", "PinPon", "Tenis");
    /**
     * List of Integers containing the drawables of the sports that will be shown
     */
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
    /**
     * RecyclerView containing an adapter which will handle the visualization of a viewHolder's elements
     */
    private RecyclerView recyclerView;
    /**
     * SportAdapter containing a list of sports and images that will handle the visualization
     * of a viewHolder's elements
     */
    private SportAdapter adapter;

    /**
     * OnCreate method that sets the recyclerView's adapter and the layout manager
     * @param savedInstanceState If the activity is being re-initialized after
     *     previously being shut down then this Bundle contains the data it most
     *     recently supplied in {@link #onSaveInstanceState}.  <b><i>Note: Otherwise it is null.</i></b>
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        adapter = new SportAdapter(names, images);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    /**
     * OnCreateOptionsMenu method that inflates a predefined menu onto the default Options Menu
     * @param menu The options menu in which you place your items.
     *
     * @return a boolean representing whether the creation was successfull or not
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * ShowSelectedCheckBoxes method that shows a Toast containing the checkboxes that were selected
     * if no checkbox was selected it will show a message saying that nothing was selected
     * @param view The view that is executing the method
     */
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