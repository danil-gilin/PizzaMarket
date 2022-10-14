package com.example.foodmarket.domain

import com.example.foodmarket.data.Repository

import com.example.foodmarket.entity.pizza.PizzaItem
import javax.inject.Inject

class GetListPizzaUseCase  @Inject constructor(private val repository: Repository) {

    suspend fun getListPizza():List<PizzaItem>{
        return repository.getListPizza()
    }
}