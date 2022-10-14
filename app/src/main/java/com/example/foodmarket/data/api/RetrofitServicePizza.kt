package com.example.foodmarket.data.api

import com.example.foodmarket.entity.pizza.PizzaItem
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

private const val BASE_URL="https://pizza-and-desserts.p.rapidapi.com"


object RetrofitServicePizza {
    private val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val searchFood:FoodApi= retrofit.create(FoodApi::class.java)
}


interface FoodApi {
    @Headers("X-RapidAPI-Key:4ba9539e4emsh78db808a758ea34p1110aajsn72db75ef7c63","X-RapidAPI-Host:pizza-and-desserts.p.rapidapi.com")
    @GET("/pizzas")
    suspend fun getPizza():List<PizzaItem>
}