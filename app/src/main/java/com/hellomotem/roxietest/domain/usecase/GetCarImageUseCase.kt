package com.hellomotem.roxietest.domain.usecase

import com.hellomotem.roxietest.domain.repository.OrdersRepository

class GetCarImageUseCase(private val ordersRepository: OrdersRepository) {

    suspend operator fun invoke(imageName: String) = ordersRepository.fetchCarImage(imageName)
}