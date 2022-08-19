package com.hellomotem.roxietest.domain.usecase

import com.hellomotem.roxietest.domain.repository.Repository

class GetActiveOrdersUseCase(private val repository: Repository) {

    suspend operator fun invoke() = repository.fetchActiveOrders()
}