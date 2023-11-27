package com.example.practica4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.example.practica4.Filter;
import com.example.practica4.NewPlayer;
import com.example.practica4.Play;
import com.example.practica4.Preferences;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);

        toolbar.inflateMenu(R.menu.main);
        toolbar.setOnMenuItemClickListener(item -> {
            if(item.getItemId() == R.id.action_search) launchFilter();
            return onContextItemSelected(item);
        });

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

    public void launchAbout(View view){
        buttonPressed();
        Intent i = new Intent(this, About.class);
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