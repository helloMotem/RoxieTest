package com.hellomotem.roxietest.presentation.entity

data class ActiveOrderUi(
    val id: Int,
    val startAddress: AddressUi,
    val endAddress: AddressUi,
    val price: PriceUi,
    val orderTime: OrderTimeUi,
    val vehicle: VehicleUi
)