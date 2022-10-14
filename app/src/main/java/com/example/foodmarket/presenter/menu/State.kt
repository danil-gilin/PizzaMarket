package com.example.foodmarket.presenter.menu


import com.example.foodmarket.entity.pizza.PizzaItem

sealed interface State{
    data class Success(val listPizza:List<PizzaItem>):State
    object Loading:State
    data class Error(val message:String):State
}