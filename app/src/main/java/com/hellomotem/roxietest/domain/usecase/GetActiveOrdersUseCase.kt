package com.hellomotem.roxietest.domain.usecase

import com.hellomotem.roxietest.domain.repository.OrdersRepository

class GetActiveOrdersUseCase(private val ordersRepository: OrdersRepository) {

    suspend operator fun invoke() = ordersRepository.fetchActiveOrders()
}