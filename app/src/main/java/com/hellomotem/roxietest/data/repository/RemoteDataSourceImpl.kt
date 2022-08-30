package com.hellomotem.roxietest.data.repository

import com.hellomotem.roxietest.data.api.OrdersService
import com.hellomotem.roxietest.data.mapper.ActiveOrderResponseMapper
import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.entity.CarImage
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher,
    private val service: OrdersService,
    private val orderResponseMapper: ActiveOrderResponseMapper
) : RemoteDataSource {

    override suspend fun fetchActiveOrders(): List<ActiveOrder>? {
        return withContext(dispatcher) {
            service.getActiveOrders().body()
                ?.let { orderResponseMapper.map(it) }
        }
    }

    override suspend fun fetchCarImage(imageName: String): CarImage {
        return withContext(dispatcher) {
            val response = service.getCarImage(imageName = imageName).body()!!
            CarImage.ApiCarImage(response)
        }
    }
}