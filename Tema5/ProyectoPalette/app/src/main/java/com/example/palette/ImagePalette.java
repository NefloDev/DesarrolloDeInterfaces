package com.example.palette;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.ColorUtils;
import androidx.palette.graphics.Palette;

import com.google.android.material.appbar.MaterialToolbar;

public class ImagePalette extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        setContentView(R.layout.activity_image_palette);

        Fade fade = new Fade();
        fade.setDuration(1000);
        getWindow().setEnterTransition(fade);

        MaterialToolbar materialToolbar = findViewById(R.id.materialToolbar);
        TextView lightVibrantText = findViewById(R.id.lightVibrantText);
        TextView mutedText = findViewById(R.id.mutedText);
        TextView darkMutedText = findViewById(R.id.darkMutedText);
        TextView lightMutedText = findViewById(R.id.lightMutedText);
        
        // Obtén la imagen seleccionada del Intent
        int selectedImage = getIntent().getIntExtra("image_resource", 0);
        
        // Configura la imagen en el ImageView
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(selectedImage);

        Bitmap btmp = ((BitmapDrawable)imageView.getDrawable()).getBitmap();

        Palette.Builder builder =  Palette.from(btmp);

        materialToolbar.setBackgroundColor(builder.generate().getVibrantColor(Color.WHITE));
        getWindow().setStatusBarColor(builder.generate().getDarkVibrantColor(Color.WHITE));
        lightVibrantText.setBackgroundColor(builder.generate().getLightVibrantColor(Color.WHITE));
        mutedText.setBackgroundColor(builder.generate().getMutedColor(Color.WHITE));
        darkMutedText.setBackgroundColor(builder.generate().getDarkMutedColor(Color.WHITE));
        lightMutedText.setBackgroundColor(builder.generate().getLightMutedColor(Color.WHITE));

        materialToolbar.setTitleTextColor(
                getContrastColor(((ColorDrawable)materialToolbar.getBackground()).getColor()));
        lightVibrantText.setTextColor(
                getContrastColor(((ColorDrawable)lightVibrantText.getBackground()).getColor()));
        mutedText.setTextColor(
                getContrastColor(((ColorDrawable)mutedText.getBackground()).getColor()));
        darkMutedText.setTextColor(
                getContrastColor(((ColorDrawable)darkMutedText.getBackground()).getColor()));
        lightMutedText.setTextColor(
                getContrastColor(((ColorDrawable)lightMutedText.getBackground()).getColor()));
    }

    private int getContrastColor(int color){
        if(ColorUtils.calculateLuminance(color) < 0.5f){
            return Color.WHITE;
        }else{
            return Color.BLACK;
        }
    }
}
