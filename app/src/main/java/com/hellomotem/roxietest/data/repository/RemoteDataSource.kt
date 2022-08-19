package com.hellomotem.roxietest.data.repository

import com.hellomotem.roxietest.data.entity.ActiveOrderResponse
import com.hellomotem.roxietest.data.entity.CarImageResponse
import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.entity.CarImage

interface RemoteDataSource {

    suspend fun fetchActiveOrders(): Result<List<ActiveOrder>>

    suspend fun fetchCarImage(url: String): Result<CarImage>
}