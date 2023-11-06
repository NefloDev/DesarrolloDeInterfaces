package com.example.practica4.Entities;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practica4.R;

import java.util.List;

public class GenerosAdapter extends RecyclerView.Adapter<GenerosViewHolder> {

    private List<String> stringList;
    private Context context;

    public GenerosAdapter(List<String> stringList, Context context){
        this.stringList = stringList;
        this.context = context;
    }

    @NonNull
    @Override
    public GenerosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.viewholder_layout, parent, false);
        return new GenerosViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull GenerosViewHolder holder, int position) {
        String item = stringList.get(position);
        holder.text.setText(item);

        holder.text.setOnClickListener(v -> Toast.makeText(context, item, Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return stringList == null ? 0 : stringList.size();
    }
}
