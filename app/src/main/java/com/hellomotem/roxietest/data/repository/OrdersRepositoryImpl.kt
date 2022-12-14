package com.hellomotem.roxietest.data.repository

import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.domain.entity.CarImage
import com.hellomotem.roxietest.domain.repository.OrdersRepository
import javax.inject.Inject

class OrdersRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : OrdersRepository {

    override suspend fun fetchActiveOrders(): List<ActiveOrder>? =
        remoteDataSource.fetchActiveOrders()

    override suspend fun fetchCarImage(imageName: String): CarImage =
        remoteDataSource.fetchCarImage(imageName)

    override suspend fun getLocalCarImage(name: String): CarImage? =
        localDataSource.getCarImage(name)

    override suspend fun saveCarImage(name: String, carImage: CarImage) =
        localDataSource.saveCarImage(name, carImage)

    override suspend fun deleteCarImage(name: String): Boolean =
        localDataSource.deleteCarImage(name)
}