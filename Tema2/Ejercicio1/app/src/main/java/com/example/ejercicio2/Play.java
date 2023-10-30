package com.example.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.List;
import java.util.stream.Collectors;

public class Play extends AppCompatActivity {

    private List<CheckBox> checkBoxes;
    private List<String> selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        checkBoxes = List.of(
            findViewById(R.id.angryBirdsCBox),
            findViewById(R.id.dragonFlyCBox),
            findViewById(R.id.hillClimbRaceCBox),
            findViewById(R.id.radiantDefenseCBox),
            findViewById(R.id.pocketSoccerCBox),
            findViewById(R.id.ninjaJumpCBox)
        );
    }

    public void checkButtonOnClick(View view) {
        selected = checkBoxes.stream().filter(CheckBox::isChecked).map(c -> c.getText().toString()).collect(Collectors.toList());
        String message;

        message = selected.isEmpty() ? "No has seleccionado ningún juego" : "Has seleccionado: " + String.join(", ", selected);

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}