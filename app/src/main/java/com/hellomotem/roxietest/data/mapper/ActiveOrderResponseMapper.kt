package com.hellomotem.roxietest.data.mapper

import com.hellomotem.roxietest.data.api.ActiveOrderResponse
import com.hellomotem.roxietest.domain.entity.ActiveOrder

interface ListMapper

class ActiveOrderResponseMapper(
    private val addressResponseMapper: AddressResponseMapper,
    private val priceResponseMapper: PriceResponseMapper,
    private val vehicleResponseMapper: VehicleResponseMapper
) : Mapper<List<ActiveOrderResponse>, List<ActiveOrder>> {

    override fun map(data: List<ActiveOrderResponse>): List<ActiveOrder> {
        return data.map {
            ActiveOrder(
                id = it.id,
                startAddress = addressResponseMapper.map(it.startAddress),
                endAddress = addressResponseMapper.map(it.endAddress),
                price = priceResponseMapper.map(it.price),
                orderTime = it.orderTime,
                vehicle = vehicleResponseMapper.map(it.vehicle)
            )
        }
    }
}