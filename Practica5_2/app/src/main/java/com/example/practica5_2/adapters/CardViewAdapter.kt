package com.example.practica5_2.adapters

import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.practica5_2.R

class CardViewAdapter(private val imageList : ArrayList<Int>?, val titleList : ArrayList<String>?) : RecyclerView.Adapter<CardViewAdapter.CardViewHolder>() {
    inner class CardViewHolder(itemView: View) : ViewHolder(itemView){
        val image : ImageView = itemView.findViewById(R.id.viewImage)
        val toolbar: Toolbar = itemView.findViewById(R.id.toolbar)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_card_layout, parent, false)
        return CardViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return imageList?.let { titleList?.let { imageList.size } ?: kotlin.run { 0 } } ?: kotlin.run { 0 }
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.image.setImageResource(imageList!![position])
        holder.toolbar.title = titleList!![position]
        holder.toolbar.inflateMenu(R.menu.toolbar_menu)
        holder.toolbar.setOnMenuItemClickListener { item ->
            when (item!!.title) {
                "Eliminar" -> {
                    imageList.removeAt(position)
                    this@CardViewAdapter.notifyItemRemoved(holder.adapterPosition)}
                "Copiar" -> {
                    imageList.add(holder.adapterPosition+1, imageList[holder.adapterPosition])
                    this@CardViewAdapter.notifyItemInserted(holder.adapterPosition)}
            }
            false
        }
    }
}
