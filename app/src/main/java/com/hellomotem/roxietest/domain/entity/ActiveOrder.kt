package com.hellomotem.roxietest.domain.entity

data class ActiveOrder(
    val id: Int,
    val startAddress: Address,
    val endAddress: Address,
    val price: Price,
    val orderTime: String,
    val vehicle: Vehicle
)

data class Address(
    val city: String,
    val address: String
)

data class Price(
    val amount: Long,
    val currency: String
)

data class Vehicle(
    val regNumber: String,
    val modelName: String,
    val photo: String,
    val driverName: String
)