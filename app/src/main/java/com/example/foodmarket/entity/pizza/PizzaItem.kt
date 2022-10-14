package com.example.foodmarket.entity.pizza


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PizzaItem(
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "img")
    val img: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "price")
    val price: Int,
    @Json(name = "quantity")
    val quantity: Int,
    @Json(name = "sizeandcrust")
    val sizeandcrust: List<Sizeandcrust>,
    @Json(name = "veg")
    val veg: Boolean
)