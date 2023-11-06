package com.example.practica4.Entities;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica4.R;

public class GenerosViewHolder extends RecyclerView.ViewHolder{
    protected TextView text;
    public GenerosViewHolder(@NonNull View itemView) {
        super(itemView);
        text = itemView.findViewById(R.id.viewHolderText);
    }
}
