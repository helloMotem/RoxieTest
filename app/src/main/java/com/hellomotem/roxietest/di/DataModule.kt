package com.hellomotem.roxietest.di

import com.hellomotem.roxietest.data.api.OrdersService
import com.hellomotem.roxietest.data.repository.LocalDataSource
import com.hellomotem.roxietest.data.repository.OrdersRepositoryImpl
import com.hellomotem.roxietest.data.repository.RemoteDataSource
import com.hellomotem.roxietest.domain.repository.OrdersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
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
}
