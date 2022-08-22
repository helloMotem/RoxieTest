package com.hellomotem.roxietest.presentation.activeorders

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellomotem.roxietest.domain.usecase.GetActiveOrdersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ActiveOrdersViewModel @Inject constructor(
    private val getActiveOrdersUseCase: GetActiveOrdersUseCase
) : ViewModel() {

    private val _state = MutableLiveData<ActiveOrdersUiState>()
    val state: LiveData<ActiveOrdersUiState> = _state

    init {
        viewModelScope.launch {
            _state.value = ActiveOrdersUiState.Loading
            _state.value = getActiveOrdersUseCase()?.let {
                ActiveOrdersUiState.Success(it)
            } ?: ActiveOrdersUiState.Error
        }
    }
}
