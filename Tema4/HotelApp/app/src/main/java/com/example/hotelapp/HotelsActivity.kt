package com.example.hotelapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotelapp.databinding.ActivityHotelsBinding
import com.example.hotelapp.databinding.HotelRecyclerCardBinding

class HotelsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHotelsBinding
    private val hotelImageList = listOf(
        R.drawable.hotel1,
        R.drawable.hotel2,
        R.drawable.hotel3,
        R.drawable.hotel4,
        R.drawable.hotel5
    )
    private val hotelNameList = listOf(
        "Hotel 1",
        "Hotel 2",
        "Hotel 3",
        "Hotel 4",
        "Hotel 5"
    )
    private val hotelAddressList = listOf(
        "Address 1",
        "Address 2",
        "Address 3",
        "Address 4",
        "Address 5"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHotelsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.hotelsToolbar)
        binding.hotelsToolbar.setOnMenuItemClickListener {item ->
            if(item.itemId == R.id.visited){
                val i = Intent(this@HotelsActivity, VisitedActivity::class.java)
                startActivity(i)
            }
            return@setOnMenuItemClickListener onContextItemSelected(item)
        }

        binding.recyclerHotels.adapter = HotelRecyclerAdapter(
            hotelImageList, hotelNameList, hotelAddressList)
        binding.recyclerHotels.layoutManager = LinearLayoutManager(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return true
    }

    inner class HotelRecyclerAdapter(
        val imageList: List<Int>, val nameList: List<String>, val addressList : List<String>)
        : RecyclerView.Adapter<HotelRecyclerAdapter.HotelRecyclerCardViewHolder>() {
        inner class HotelRecyclerCardViewHolder(val binding : HotelRecyclerCardBinding)
            : RecyclerView.ViewHolder(binding.root){}

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HotelRecyclerCardViewHolder {
            return HotelRecyclerCardViewHolder(
                HotelRecyclerCardBinding.inflate(layoutInflater, parent, false))
        }

        override fun getItemCount(): Int {
            return nameList.size
        }

        override fun onBindViewHolder(holder: HotelRecyclerCardViewHolder, position: Int) {
            holder.binding.hotelImg.setImageResource(imageList[position])
            holder.binding.name.text = nameList[position]
            holder.binding.streetName.text = addressList[position]
            holder.binding.favButton.setOnClickListener {
                Toast.makeText(this@HotelsActivity,
                    nameList[position] + " was added to favorites", Toast.LENGTH_SHORT).show()
            }
        }

    }

}