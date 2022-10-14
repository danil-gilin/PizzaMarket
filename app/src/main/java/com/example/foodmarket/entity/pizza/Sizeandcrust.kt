package com.example.foodmarket.entity.pizza


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sizeandcrust(
    @Json(name = "mediumPan")
    val mediumPan: List<MediumPan>?,
    @Json(name = "medium stuffed crust kebab")
    val mediumStuffedCrustKebab: List<MediumStuffedCrustKebab>?,
    @Json(name = "medium stuffed crust-veg kebab")
    val mediumStuffedCrustVegKebab: List<MediumStuffedCrustVegKebab>?,
    @Json(name = "mediumstuffedcrustcheesemax")
    val mediumstuffedcrustcheesemax: List<Mediumstuffedcrustcheesemax>?,
    @Json(name = "mediumstuffedcrustchickenseekhkebab")
    val mediumstuffedcrustchickenseekhkebab: List<Mediumstuffedcrustchickenseekhkebab>?,
    @Json(name = "mediumstuffedcrustvegkebab")
    val mediumstuffedcrustvegkebab: List<MediumstuffedcrustvegkebabX>?
)