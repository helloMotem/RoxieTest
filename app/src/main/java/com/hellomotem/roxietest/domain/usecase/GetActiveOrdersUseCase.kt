package com.hellomotem.roxietest.domain.usecase

import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.repository.OrdersRepository
import java.text.SimpleDateFormat

class GetActiveOrdersUseCase(private val ordersRepository: OrdersRepository) {

    suspend operator fun invoke() =
        ordersRepository.fetchActiveOrders()?.sortedByDescending { it.orderTime }

    private fun sortByDesc(orders: List<ActiveOrder>) {

    }

    private fun sortByAsc(orders: List<ActiveOrder>) {

    }
}