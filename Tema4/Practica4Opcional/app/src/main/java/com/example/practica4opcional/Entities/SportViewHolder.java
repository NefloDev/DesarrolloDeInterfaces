package com.example.practica4opcional.Entities;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica4opcional.R;

public class SportViewHolder extends RecyclerView.ViewHolder {

    protected ImageView image;
    protected CheckBox checkBox;
    public SportViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.recyclerImage);
        checkBox = itemView.findViewById(R.id.recyclerCheckBox);
    }

    public CheckBox getCheckBox(){
        return checkBox;
    }

}