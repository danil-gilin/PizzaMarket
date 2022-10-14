package com.example.foodmarket.entity.pizza

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pizza(
    @Json(name = "listPizza")
    val listPizza: List<PizzaItem>
)
