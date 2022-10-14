package com.example.foodmarket.entity.pizza


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MediumStuffedCrustKebab(
    @Json(name = "price")
    val price: Int
)