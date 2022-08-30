package com.hellomotem.roxietest.domain.usecase

import com.hellomotem.roxietest.domain.entity.CarImage
import com.hellomotem.roxietest.domain.repository.OrdersRepository

class SaveCarImageUseCase(private val ordersRepository: OrdersRepository) {

    suspend operator fun invoke(name: String, carImage: CarImage) {
        return ordersRepository.saveCarImage(name, carImage)
    }
}

