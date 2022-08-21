package com.hellomotem.roxietest.presentation

import androidx.lifecycle.ViewModel
import com.hellomotem.roxietest.domain.usecase.GetCarImageUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderDetailViewModel @Inject constructor(
    private val getCarImageUseCase: GetCarImageUseCase
) : ViewModel() {
    // TODO: Implement the ViewModel
}