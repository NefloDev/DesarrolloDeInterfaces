package com.example.practica5_4.adapter

import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.RatingBar.OnRatingBarChangeListener
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.practica5_4.R

class RestaurantAdapter(val names : List<String>, val locations : List<String>, val images : List<Int>, val ratings : List<Float>) :
    Adapter<RestaurantAdapter.RestaurantCardViewHolder>() {
    inner class RestaurantCardViewHolder(itemView: View) : ViewHolder(itemView){
        val restaurantName : TextView = itemView.findViewById(R.id.placeName)
        val restaurantImage : ImageView = itemView.findViewById(R.id.cardImage)
        val restaurantRatingBar : RatingBar = itemView.findViewById(R.id.placeRating)
        val restaurantRating : TextView = itemView.findViewById(R.id.ratingValue)
        val restaurantLocation : TextView = itemView.findViewById(R.id.location)
        init {
            itemView.findViewById<Button>(R.id.reserveButton).setOnClickListener{
                Toast.makeText(itemView.context, "Reserved in " + restaurantName.text, Toast.LENGTH_SHORT).show()}
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantCardViewHolder {
        return RestaurantCardViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false))
    }

    override fun getItemCount(): Int {
        return names.size
    }

    override fun onBindViewHolder(holder: RestaurantCardViewHolder, position: Int) {
        holder.restaurantName.text = names[position]
        holder.restaurantImage.setImageResource(images[position])
        holder.restaurantLocation.text = locations[position]
        holder.restaurantRatingBar.rating = ratings[position]
        holder.restaurantRating.visibility = View.GONE
        holder.restaurantRating.text = ratings[position].toString()

        (holder.restaurantRatingBar as View).setOnTouchListener { v, e ->
            when (e!!.action) {
                MotionEvent.ACTION_DOWN -> holder.restaurantRating.visibility = View.VISIBLE
            }
            v!!.performClick()
        }

    }

}