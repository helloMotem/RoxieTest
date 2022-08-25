package com.hellomotem.roxietest.presentation.activeorders

import com.hellomotem.roxietest.presentation.entity.ActiveOrderUi


//TODO() change domain model to presentation
sealed interface ActiveOrdersUiState {
    data class Success(val orders: List<ActiveOrderUi>) : ActiveOrdersUiState
    object Loading : ActiveOrdersUiState
    object Error : ActiveOrdersUiState
    object Default: ActiveOrdersUiState
}