package com.hellomotem.roxietest.di

import com.hellomotem.roxietest.data.api.OrdersService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {

    @Provides
    fun provideBaseUrl(): String = "https://www.roxiemobile.ru/careers/test/"

    @OptIn(ExperimentalSerializationApi::class)
    @Provides
    @Singleton
    fun provideRetrofit(
        baseUrl: String,
        client: OkHttpClient
    ): Retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory(contentType = "text/html".toMediaType()))
        .baseUrl(baseUrl)
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideOrdersService(retrofit: Retrofit): OrdersService =
        retrofit.create(OrdersService::class.java)

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(10, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .build()
}