package com.example.foodmarket.presenter.basket

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class BascketViewModelFactory @Inject constructor (private val basketViewModel: BasketViewModel) :ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return basketViewModel as T
    }
}