package com.example.ejercicio2y3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.ejercicio2y3.databinding.FragmentGalleryBinding
import com.example.ejercicio2y3.databinding.GalleryImageBinding

class GalleryFragment : Fragment() {
    private lateinit var binding: FragmentGalleryBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentGalleryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = listOf(
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9
        )
        val nameList = this.resources.getStringArray(R.array.title_array).asList()

        val adapter = GalleryImageRecyclerAdapter(imageList, nameList)
        binding.recycler.adapter = adapter

        binding.recycler.layoutManager = GridLayoutManager(this.requireActivity(), 2, VERTICAL, false)
    }

    inner class GalleryImageRecyclerAdapter(val imageList : List<Int>, val nameList : List<String>) :
        RecyclerView.Adapter<GalleryImageRecyclerAdapter.GalleryImageViewHolder>() {
        inner class GalleryImageViewHolder(val binding : GalleryImageBinding) : ViewHolder(binding.root)

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GalleryImageViewHolder {
            return GalleryImageViewHolder(GalleryImageBinding.inflate(layoutInflater, parent, false))
        }

        override fun getItemCount(): Int {
            return imageList.size
        }

        override fun onBindViewHolder(holder: GalleryImageViewHolder, position: Int) {
            holder.binding.cardImage.setImageResource(imageList[position])
            holder.binding.cardTitle.text = nameList[position]
        }

    }

}