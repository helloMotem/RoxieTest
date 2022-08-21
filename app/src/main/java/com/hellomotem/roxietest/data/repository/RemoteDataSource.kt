package com.hellomotem.roxietest.data.repository

import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.entity.CarImage

interface RemoteDataSource {

    suspend fun fetchActiveOrders(): List<ActiveOrder>?

    suspend fun fetchCarImage(imageName: String): CarImage?
}