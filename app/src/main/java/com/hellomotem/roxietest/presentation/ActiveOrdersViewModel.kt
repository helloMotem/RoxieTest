package com.hellomotem.roxietest.presentation

import androidx.lifecycle.ViewModel
import com.hellomotem.roxietest.domain.usecase.GetActiveOrdersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ActiveOrdersViewModel @Inject constructor(
    private val getActiveOrdersUseCase: GetActiveOrdersUseCase
) : ViewModel() {
    // TODO: Implement the ViewModel
}