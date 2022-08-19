package com.hellomotem.roxietest.domain.usecase

import com.hellomotem.roxietest.domain.repository.Repository

class GetCarImageUseCase(private val repository: Repository) {

    suspend operator fun invoke(imageName: String) = repository.fetchCarImage(imageName)
}