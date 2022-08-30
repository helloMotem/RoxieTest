package com.hellomotem.roxietest.domain.usecase

import com.hellomotem.roxietest.domain.entity.CarImage
import com.hellomotem.roxietest.domain.repository.OrdersRepository

class GetCarImageUseCase(private val ordersRepository: OrdersRepository) {

    suspend operator fun invoke(imageName: String): CarImage = with(ordersRepository) {
        getLocalCarImage(imageName) ?: fetchCarImage(imageName)
    }
}