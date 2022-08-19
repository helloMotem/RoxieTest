package com.hellomotem.roxietest.data.repository

import com.hellomotem.roxietest.data.entity.ActiveOrderResponse
import com.hellomotem.roxietest.data.entity.CarImageResponse
import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.entity.CarImage

class RemoteDataSourceImpl: RemoteDataSource {
    override suspend fun fetchActiveOrders(): Result<List<ActiveOrder>> {
        TODO("Not yet implemented")
    }

    override suspend fun fetchCarImage(url: String): Result<CarImage> {
        TODO("Not yet implemented")
    }
}