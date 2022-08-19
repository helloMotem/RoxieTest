package com.hellomotem.roxietest.presentation

import androidx.lifecycle.ViewModel
import com.hellomotem.roxietest.domain.usecase.GetActiveOrdersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class ActiveOrdersViewModel(getActiveOrdersUseCase: GetActiveOrdersUseCase) : ViewModel() {
    // TODO: Implement the ViewModel
}