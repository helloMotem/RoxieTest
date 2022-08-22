package com.hellomotem.roxietest.di

import com.hellomotem.roxietest.domain.repository.OrdersRepository
import com.hellomotem.roxietest.domain.usecase.GetActiveOrdersUseCase
import com.hellomotem.roxietest.domain.usecase.GetCarImageUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class DomainModule {

    @Provides
    fun provideGetActiveOrdersUseCase(ordersRepository: OrdersRepository) : GetActiveOrdersUseCase {
        return GetActiveOrdersUseCase(ordersRepository = ordersRepository)
    }

    @Provides
    fun provideGetCarImageUseCase(ordersRepository: OrdersRepository): GetCarImageUseCase {
        return GetCarImageUseCase(ordersRepository = ordersRepository)
    }
}