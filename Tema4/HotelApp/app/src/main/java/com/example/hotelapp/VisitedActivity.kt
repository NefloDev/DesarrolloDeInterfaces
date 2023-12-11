package com.example.hotelapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.hotelapp.databinding.ActivityVisitedBinding
import com.example.hotelapp.databinding.VisitedHotelCardBinding

class VisitedActivity : AppCompatActivity() {
    private lateinit var binding : ActivityVisitedBinding
    private val hotelImageList = listOf(
        R.drawable.hotel1,
        R.drawable.hotel2,
        R.drawable.hotel3,
        R.drawable.hotel4,
        R.drawable.hotel5
    )
    private val hotelRatingList = listOf(1f, 2f, 3f, 4f, 5f)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityVisitedBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.visitedRecycler.adapter = VisitedRecyclerViewAdapter(hotelImageList, hotelRatingList)

    }

    inner class VisitedRecyclerViewAdapter (
        val imageList: List<Int>, val ratingList : List<Float>) :
        Adapter<VisitedRecyclerViewAdapter.VisitedHotelCardViewHolder>() {
        inner class VisitedHotelCardViewHolder(val binding : VisitedHotelCardBinding)
            : ViewHolder(binding.root) {}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        : VisitedHotelCardViewHolder {
            return VisitedHotelCardViewHolder(
                VisitedHotelCardBinding.inflate(layoutInflater, parent, false))
        }

        override fun getItemCount(): Int {
            return imageList.size
        }

        override fun onBindViewHolder(holder: VisitedHotelCardViewHolder, position: Int) {
            holder.binding.imageView.setImageResource(imageList[position])
            holder.binding.ratingBar.rating = ratingList[position]
        }
    }
}