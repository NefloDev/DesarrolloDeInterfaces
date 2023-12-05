package com.example.coffeeshop.adapters

import com.example.coffeeshop.R

class ShopModel {
    val shops : ArrayList<Shop> = arrayListOf(
        Shop("Coffee Shop 1", "Address 1", 0f, R.drawable.images),
        Shop("Coffee Shop 2", "Address 2", 0f, R.drawable.images1),
        Shop("Coffee Shop 3", "Address 3", 0f, R.drawable.images2),
        Shop("Coffee Shop 4", "Address 4", 0f, R.drawable.images3),
        Shop("Coffee Shop 5", "Address 5", 0f, R.drawable.images4),
        Shop("Coffee Shop 6", "Address 6", 0f, R.drawable.images5),
        Shop("Coffee Shop 7", "Address 7", 0f, R.drawable.images6)
    )

    interface Callback{
        fun whenFinished(list : ArrayList<Shop>)
    }

    fun obtain() : ArrayList<Shop>{
        return shops;
    }

    fun update(shop: Shop, valoration: Float, callback: Callback){
        shop.valoration = valoration
        callback.whenFinished(shops)
    }
}