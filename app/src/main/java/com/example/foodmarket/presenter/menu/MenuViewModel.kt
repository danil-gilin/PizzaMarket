package com.example.foodmarket.presenter.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodmarket.domain.GetListPizzaUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor (private val getListPizzaUseCase: GetListPizzaUseCase): ViewModel() {
    private val _state= MutableStateFlow<State>(State.Loading)
    val state=_state.asStateFlow()

    fun getPizza(){
        viewModelScope.launch {
            _state.value = State.Loading
            _state.value=State.Success(getListPizzaUseCase.getListPizza())
        }
    }
}