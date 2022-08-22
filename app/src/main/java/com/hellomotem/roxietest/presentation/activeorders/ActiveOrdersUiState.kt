package com.hellomotem.roxietest.presentation.activeorders

import com.hellomotem.roxietest.domain.entity.ActiveOrder


//TODO() change domain model to presentation
sealed interface ActiveOrdersUiState {
    data class Success(val orders: List<ActiveOrder>) : ActiveOrdersUiState
    object Loading : ActiveOrdersUiState
    object Error : ActiveOrdersUiState
    object Default: ActiveOrdersUiState
}