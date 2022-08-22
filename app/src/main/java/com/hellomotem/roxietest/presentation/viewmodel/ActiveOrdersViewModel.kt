package com.hellomotem.roxietest.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellomotem.roxietest.domain.usecase.GetActiveOrdersUseCase
import com.hellomotem.roxietest.presentation.state.ActiveOrdersUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActiveOrdersViewModel @Inject constructor(
    private val getActiveOrdersUseCase: GetActiveOrdersUseCase
) : ViewModel() {

    private val _state = MutableLiveData<ActiveOrdersUiState>()
    val state: LiveData<ActiveOrdersUiState> = _state

    fun load() = viewModelScope.launch {
        val activeOrders = getActiveOrdersUseCase()
    }
}

