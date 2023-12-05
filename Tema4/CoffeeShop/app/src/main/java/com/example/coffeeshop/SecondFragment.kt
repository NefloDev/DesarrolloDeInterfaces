package com.example.coffeeshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.adapters.ShopsViewModel
import com.example.coffeeshop.databinding.FragmentSecondBinding
import com.example.coffeeshop.databinding.ReviewCardBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    private lateinit var viewModel: ShopsViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[ShopsViewModel::class.java]
        viewModel.selected().observe(viewLifecycleOwner){element ->
            binding.coffeeRoomRating.rating = element.valoration
            binding.coffeeRoomRating.setOnRatingBarChangeListener { _, rating, fromUser ->
                if (fromUser){
                    viewModel.update(element, rating)
                }
            }
        }
        val adapter = ReviewCardRecyclerAdapter()
        adapter.setList(listOf(
            "Muy recomendable. Volveré seguro",
            "Acogedor. Muy buen ambiente",
            "Buenos precios",
            "Servicio algo flojo",
            "Para repetir... extensa carta de cafés"
        ))
        binding.textRecycler.adapter = adapter
        binding.textRecycler.layoutManager = GridLayoutManager(this@SecondFragment.context, 2)
    }



    inner class ReviewCardRecyclerAdapter() :
        RecyclerView.Adapter<ReviewCardRecyclerAdapter.ReviewCardViewHolder>() {
        inner class ReviewCardViewHolder(val binding : ReviewCardBinding) : RecyclerView.ViewHolder(binding.root){}

        private lateinit var reviews : List<String>
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewCardViewHolder {
            return ReviewCardViewHolder(ReviewCardBinding.inflate(layoutInflater, parent, false))
        }

        override fun getItemCount(): Int {
            return reviews.size
        }

        override fun onBindViewHolder(holder: ReviewCardViewHolder, position: Int) {
            holder.binding.textView.text = reviews[position]
        }

        fun setList(list : List<String>){
            reviews = list
        }

        fun getReview(position : Int) : String {
            return reviews[position]
        }
    }
}