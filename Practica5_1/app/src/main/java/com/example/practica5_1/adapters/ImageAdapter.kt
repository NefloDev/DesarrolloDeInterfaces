package com.example.practica5_1.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.practica5_1.R

class ImageAdapter(private val imageList: List<Int>?) : Adapter<ImageAdapter.ImageViewHolder>() {
    private lateinit var listener: OnItemClickListener
    inner class ImageViewHolder(itemView : View) : ViewHolder(itemView){
        var image : ImageView = itemView.findViewById(R.id.recyclerImage)
        init {
            itemView.setOnClickListener{
                listener.OnItemClick(itemView, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val layoutView = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_layout, parent, false)
        return ImageViewHolder(layoutView)
    }

    override fun getItemCount(): Int {
        return imageList?.let { return imageList.size } ?: kotlin.run { 0 }
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.image.setImageResource(imageList!![position])
    }
    fun setOnItemClickListener(listener: OnItemClickListener){
        this.listener = listener
    }
    interface OnItemClickListener{
        fun OnItemClick(view:View, position:Int)
    }
}