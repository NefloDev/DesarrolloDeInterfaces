package com.example.coffeeshop.adapters

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

class ShopsViewModel(application: Application) : AndroidViewModel(application) {
    private val selectedShopMutableLiveData = MutableLiveData<Shop>()
    private val model = ShopModel()
    private val elementListMutableLiveData = MutableLiveData(model.obtain())
    fun obtain() : MutableLiveData<ArrayList<Shop>>{
        return elementListMutableLiveData
    }
    fun select(shop : Shop){
        selectedShopMutableLiveData.value = shop
    }
    fun selected() : MutableLiveData<Shop>{
        return selectedShopMutableLiveData
    }
    fun update(shop: Shop, valoration : Float){
        model.update(shop, valoration, object : ShopModel.Callback{
            override fun whenFinished(list: ArrayList<Shop>) {
                elementListMutableLiveData.value = list
            }
        })
    }
}