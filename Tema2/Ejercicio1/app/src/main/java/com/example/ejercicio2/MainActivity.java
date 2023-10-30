package com.example.ejercicio2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageView menuButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menuButton = findViewById(R.id.menuButton);

        registerForContextMenu(menuButton);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.main, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.action_search){
            launchFilter();
        }

        return super.onContextItemSelected(item);
    }

    public void launchPlay(View view){
        buttonPressed();
        Intent i = new Intent(this, Play.class);
        startActivity(i);
    }

    public void launchNewPlayer(View view){
        buttonPressed();
        Intent i = new Intent(this, NewPlayer.class);
        startActivity(i);
    }

    public void launchPreferences(View view){
        buttonPressed();
        Intent i = new Intent(this, Preferences.class);
        startActivity(i);
    }

    public void launchFilter(){
        Intent i = new Intent(this, Filter.class);
        startActivity(i);
    }
    
    private void buttonPressed(){
        Toast.makeText(this, "Has pulsado el material button", Toast.LENGTH_SHORT).show();
    }
}