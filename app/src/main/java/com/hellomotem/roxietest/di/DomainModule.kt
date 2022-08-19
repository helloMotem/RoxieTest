package com.hellomotem.roxietest.di

import com.hellomotem.roxietest.domain.repository.Repository
import com.hellomotem.roxietest.domain.usecase.GetActiveOrdersUseCase
import com.hellomotem.roxietest.domain.usecase.GetCarImageUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetActiveOrdersUseCase(repository: Repository) : GetActiveOrdersUseCase {
        return GetActiveOrdersUseCase(repository = repository)
    }

    @Provides
    fun provideGetCarImageUseCase(repository: Repository): GetCarImageUseCase {
        return GetCarImageUseCase(repository = repository)
    }
}