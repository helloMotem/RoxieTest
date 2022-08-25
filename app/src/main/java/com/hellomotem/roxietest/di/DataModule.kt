package com.hellomotem.roxietest.di

import com.hellomotem.roxietest.data.api.OrdersService
import com.hellomotem.roxietest.data.mapper.*
import com.hellomotem.roxietest.data.repository.*
import com.hellomotem.roxietest.domain.repository.OrdersRepository
import com.hellomotem.roxietest.presentation.mapper.ActiveOrderUiMapper
import com.hellomotem.roxietest.presentation.mapper.AddressUiMapper
import com.hellomotem.roxietest.presentation.mapper.PriceUiMapper
import com.hellomotem.roxietest.presentation.mapper.VehicleUiMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideOrdersRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): OrdersRepository = OrdersRepositoryImpl(
        remoteDataSource = remoteDataSource,
        localDataSource = localDataSource
    )

    @Provides
    fun provideRemoteDataSource(
        service: OrdersService,
        activeOrderResponseMapper: ActiveOrderResponseMapper,
        carImageResponseMapper: CarImageResponseMapper
    ): RemoteDataSource = RemoteDataSourceImpl(
        service = service,
        orderResponseMapper = activeOrderResponseMapper,
        carImageResponseMapper = carImageResponseMapper
    )

    @Provides
    fun provideLocalDataSource(): LocalDataSource = LocalDataSourceImpl()

    @Provides
    fun provideActiveOrderResponseMapper(): ActiveOrderResponseMapper {
        val addressResponseMapper = AddressResponseMapper()
        val priceResponseMapper = PriceResponseMapper()
        val vehicleResponseMapper = VehicleResponseMapper()

        return ActiveOrderResponseMapper(
            addressResponseMapper = addressResponseMapper,
            priceResponseMapper = priceResponseMapper,
            vehicleResponseMapper = vehicleResponseMapper
        )
    }

    @Provides
    fun provideCarImageResponseMapper(): CarImageResponseMapper = CarImageResponseMapper()

    @Provides
    fun provideActiveOrdersUiMapper(): ActiveOrderUiMapper {
        val addressUiMapper = AddressUiMapper()
        val priceUiMapper = PriceUiMapper()
        val vehicleUiMapper = VehicleUiMapper()

        return ActiveOrderUiMapper(
            addressUiMapper = addressUiMapper,
            priceUiMapper = priceUiMapper,
            vehicleUiMapper = vehicleUiMapper
        )
    }

}
