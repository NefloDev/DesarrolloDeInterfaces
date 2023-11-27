package com.example.ejercicio2;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Preferences extends AppCompatActivity {

    private RatingBar ratingBar;
    private SeekBar seekBar;
    private RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);

        ratingBar = findViewById(R.id.ratingBar);
        seekBar = findViewById(R.id.seekBar);
        radioGroup = findViewById(R.id.radioGroup);

        ratingBar.setOnRatingBarChangeListener((ratingBar, rating, fromUser) ->  seekBar.setProgress(ratingBar.getProgress()));

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                ratingBar.setProgress(seekBar.getProgress());
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });

    }

    public void setRating(View view){
        int id = radioGroup.getCheckedRadioButtonId();
        RadioButton checked = radioGroup.findViewById(id);
        String message;
        if(ratingBar.getProgress() > 0 && id != -1){
            message = checked.getText() + " " + ratingBar.getProgress();
        }else{
            message = id == -1 ? "No has seleccionado ningun juego" : "No has seleccionado una puntuación válida";
        }
        Toast.makeText(Preferences.this, message, Toast.LENGTH_SHORT).show();
    }
}