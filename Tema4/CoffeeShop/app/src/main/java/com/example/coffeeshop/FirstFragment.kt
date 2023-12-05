package com.example.coffeeshop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.coffeeshop.adapters.Shop
import com.example.coffeeshop.adapters.ShopsViewModel
import com.example.coffeeshop.databinding.FragmentFirstBinding
import com.example.coffeeshop.databinding.ShopCardBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var viewModel : ShopsViewModel
    private lateinit var navController : NavController
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[ShopsViewModel::class.java]
        val adapter = ShopCardRecyclerAdapter()
        navController = Navigation.findNavController(view)

        binding.recycler.adapter = adapter
        viewModel.obtain().observe(viewLifecycleOwner, adapter::setList)
    }

    inner class ShopCardRecyclerAdapter() :
        RecyclerView.Adapter<ShopCardRecyclerAdapter.ShopCardViewHolder>() {
        inner class ShopCardViewHolder(val binding : ShopCardBinding) : RecyclerView.ViewHolder(binding.root){}

        private lateinit var shops : List<Shop>
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopCardViewHolder {
            return ShopCardViewHolder(ShopCardBinding.inflate(layoutInflater, parent, false))
        }

        override fun getItemCount(): Int {
            return shops.size
        }

        override fun onBindViewHolder(holder: ShopCardViewHolder, position: Int) {
            val element = shops[position]
            holder.binding.coffeeShopTitle.text = element.name
            holder.binding.coffeeShopImg.setImageResource(element.image)
            holder.binding.address.text = element.address
            holder.binding.ratingVal.text = element.valoration.toString()
            holder.binding.ratingBar.rating = element.valoration
            holder.binding.ratingBar.setOnRatingBarChangeListener{_,rating,fromUser ->
                if (fromUser){
                    viewModel.update(element, rating)
                    holder.binding.ratingVal.text = rating.toString()
                }
            }
            holder.binding.reserveButton.setOnClickListener{v -> Toast.makeText(v.context,
                "Reserved at " + holder.binding.coffeeShopTitle.text,
                Toast.LENGTH_SHORT).show()
            }
            holder.binding.coffeeShopTitle.setOnClickListener{
                viewModel.select(element)
                navController.navigate(R.id.action_FirstFragment_to_SecondFragment)
            }
        }

        fun setList(list : List<Shop>){
            shops = list
        }

        fun getElement(position : Int) : Shop{
            return shops[position]
        }
    }

}