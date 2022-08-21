package com.hellomotem.roxietest.domain.entity

data class ActiveOrder(
    val id: Int,
    val startAddress: Address,
    val endAddress: Address,
    val price: Price,
    val orderTime: String,
    val vehicle: Vehicle
)