package com.example.practica4opcional.Entities;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica4opcional.R;

/**
 * SportViewHolder class that represents the data that will be shown in the View that will be
 * used in a recycler view
 * @author Alejandro Nebot Fores
 * @version 2023-11-27
 */

public class SportViewHolder extends RecyclerView.ViewHolder {
    /**
     * ImageView containing the drawable of the sport that will be shown
     */
    protected ImageView image;
    /**
     * CheckBox containing the selectable sport that will be shown
     */
    protected CheckBox checkBox;

    /**
     * SportViewHolder's class Constructor
     * @param itemView The view of the layout containing the visual elements
     */
    public SportViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.recyclerImage);
        checkBox = itemView.findViewById(R.id.recyclerCheckBox);
    }

    /**
     * GetCheckBox method that gives the CheckBox of the object
     * @return A CheckBox object containing the SportViewHolder object
     */
    public CheckBox getCheckBox(){
        return checkBox;
    }

}