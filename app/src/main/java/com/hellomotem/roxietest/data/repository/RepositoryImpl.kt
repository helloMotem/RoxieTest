package com.hellomotem.roxietest.data.repository

import com.hellomotem.roxietest.data.entity.ActiveOrderResponse
import com.hellomotem.roxietest.data.entity.CarImageResponse
import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.entity.CarImage
import com.hellomotem.roxietest.domain.repository.Repository

class RepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : Repository {
    override suspend fun fetchActiveOrders(): Result<List<ActiveOrder>> =
        remoteDataSource.fetchActiveOrders()

    override suspend fun fetchCarImage(url: String): Result<CarImage> =
        remoteDataSource.fetchCarImage(url)

}