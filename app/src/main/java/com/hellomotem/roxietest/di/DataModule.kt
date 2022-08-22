package com.hellomotem.roxietest.di

import com.hellomotem.roxietest.data.api.OrdersService
import com.hellomotem.roxietest.data.mapper.*
import com.hellomotem.roxietest.data.repository.*
import com.hellomotem.roxietest.domain.repository.OrdersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.intellij.lang.annotations.PrintFormat
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun provideBaseUrl(): String = "https://www.roxiemobile.ru/careers/test/"

    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        client: OkHttpClient,
        factory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(factory)
        .baseUrl(baseUrl)
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory =
        GsonConverterFactory.create()

    @Provides
    @Singleton
    fun provideOrdersService(retrofit: Retrofit): OrdersService =
        retrofit.create(OrdersService::class.java)

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
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()

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
    fun provideActiveOrderResponseMapper(
        addressResponseMapper: AddressResponseMapper,
        priceResponseMapper: PriceResponseMapper,
        vehicleResponseMapper: VehicleResponseMapper
    ): ActiveOrderResponseMapper = ActiveOrderResponseMapper(
        addressResponseMapper = addressResponseMapper,
        priceResponseMapper = priceResponseMapper,
        vehicleResponseMapper = vehicleResponseMapper
    )

    @Provides
    fun provideAddressResponseMapper(): AddressResponseMapper = AddressResponseMapper()

    @Provides
    fun providePriceResponseMapper(): PriceResponseMapper = PriceResponseMapper()

    @Provides
    fun provideVehicleResponseMapper(): VehicleResponseMapper = VehicleResponseMapper()

    @Provides
    fun provideCarImageResponseMapper(): CarImageResponseMapper = CarImageResponseMapper()
}
