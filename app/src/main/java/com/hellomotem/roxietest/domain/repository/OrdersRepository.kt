package com.hellomotem.roxietest.domain.repository

import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.entity.CarImage

interface OrdersRepository {

    suspend fun fetchActiveOrders(): List<ActiveOrder>?

    suspend fun fetchCarImage(imageName: String): CarImage?

    fun getLocalCarImage(): CarImage?
}