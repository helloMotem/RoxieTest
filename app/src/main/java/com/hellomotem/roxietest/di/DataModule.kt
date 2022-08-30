package com.hellomotem.roxietest.di

import android.content.Context
import com.hellomotem.roxietest.data.api.OrdersService
import com.hellomotem.roxietest.data.mapper.*
import com.hellomotem.roxietest.data.repository.*
import com.hellomotem.roxietest.domain.repository.OrdersRepository
import com.hellomotem.roxietest.presentation.mapper.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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
        dispatcher: CoroutineDispatcher
    ): RemoteDataSource = RemoteDataSourceImpl(
        service = service,
        orderResponseMapper = activeOrderResponseMapper,
        dispatcher = dispatcher
    )

    @Provides
    fun provideLocalDataSource(
        dispatcher: CoroutineDispatcher,
        @ApplicationContext context: Context
    ): LocalDataSource = LocalDataSourceImpl(dispatcher = dispatcher, context = context)

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

    @Provides
    fun provideCarImageUiMapper(): CarImageUiMapper = CarImageUiMapper()
}
