package com.example.foodmarket.presenter.profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.foodmarket.presenter.basket.BasketViewModel
import javax.inject.Inject

class ProfileViewModelFactory  @Inject constructor (private val profileViewModel: ProfileViewModel) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return profileViewModel as T
    }
}