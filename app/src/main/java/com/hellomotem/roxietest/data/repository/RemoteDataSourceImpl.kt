package com.hellomotem.roxietest.data.repository

import com.hellomotem.roxietest.data.api.OrdersService
import com.hellomotem.roxietest.data.mapper.ActiveOrderResponseMapper
import com.hellomotem.roxietest.data.mapper.CarImageResponseMapper
import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.entity.CarImage
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val service: OrdersService,
    private val orderResponseMapper: ActiveOrderResponseMapper,
    private val carImageResponseMapper: CarImageResponseMapper
) : RemoteDataSource {

    override suspend fun fetchActiveOrders(): List<ActiveOrder>? {
        return withContext(dispatcher) {
            service.getActiveOrders()
                .getOrNull()
                ?.let { orderResponseMapper.map(it) }
        }
    }

    override suspend fun fetchCarImage(imageName: String): CarImage? {
        return withContext(dispatcher) {
            service.getCarImage(imageName = imageName)
                .getOrNull()
                ?.let { carImageResponseMapper.map(it) }
        }
    }
}