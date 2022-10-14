package com.example.foodmarket.data

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.foodmarket.data.api.RetrofitServicePizza
import com.example.foodmarket.entity.pizza.Pizza
import com.example.foodmarket.entity.pizza.PizzaItem
import com.squareup.moshi.Moshi
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

const val SHARED_NAME="PIZZA_shared"
const val FILE_NAME="PIZZA_file"


class Repository @Inject constructor(@ApplicationContext private val context: Context) {
    private val shared=context.getSharedPreferences(SHARED_NAME, AppCompatActivity.MODE_PRIVATE)


   suspend fun getListPizza():List<PizzaItem> {
       return when{
           getInternet() !=null->getInternet()!!
           getLocal() !=null->getLocal()!!
           else -> emptyList<PizzaItem>()
       }

   }

    suspend fun getInternet():List<PizzaItem>?{
        try {
            val listPizza=RetrofitServicePizza.searchFood.getPizza()
            val pizza2=Pizza(listPizza)
            val pizzaAdapter=Moshi.Builder().build().adapter(Pizza::class.java)
            val pizzaItemModel=pizzaAdapter.toJson(pizza2)
            val editor = shared.edit()
            editor.putString(FILE_NAME,pizzaItemModel)
            editor.apply()
            return listPizza
        }catch (e:Exception){
            return null
        }
    }

    fun getLocal():List<PizzaItem>?{
        val pizza=shared.getString(FILE_NAME,null)
        val pizzaAdapter=Moshi.Builder().build().adapter(Pizza::class.java)
        if(pizza==null){
            return null
        }else{
            return pizzaAdapter.fromJson(pizza)?.listPizza
        }
    }

}