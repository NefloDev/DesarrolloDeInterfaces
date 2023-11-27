package com.example.practica4opcional.Entities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica4opcional.R;

import java.util.ArrayList;
import java.util.List;

public class SportAdapter extends RecyclerView.Adapter<SportViewHolder> {

    private List<String> names;
    private List<Integer> images;
    private ArrayList<SportViewHolder> viewHolderList;

    public SportAdapter(List<String> names, List<Integer> images){
        this.names = names;
        this.images = images;
        viewHolderList = new ArrayList<>();
    }

    @NonNull
    @Override
    public SportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_layout, parent, false);
        return new SportViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull SportViewHolder holder, int position) {
        String name = names.get(position);
        int imageId = images.get(position);

        holder.checkBox.setText(name);
        holder.image.setImageResource(imageId);
        viewHolderList.add(holder);
    }

    @Override
    public int getItemCount() {
        return images != null && names != null ? images.size() : 0;
    }

    public ArrayList<SportViewHolder> getViewHolderList(){
        return viewHolderList;
    }
}
