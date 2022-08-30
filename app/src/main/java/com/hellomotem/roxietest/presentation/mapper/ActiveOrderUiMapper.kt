package com.hellomotem.roxietest.presentation.mapper

import com.hellomotem.roxietest.data.mapper.Mapper
import com.hellomotem.roxietest.domain.entity.ActiveOrder
import com.hellomotem.roxietest.presentation.entity.ActiveOrderUi
import com.hellomotem.roxietest.presentation.entity.OrderTimeUi
import javax.inject.Inject

class ActiveOrderUiMapper @Inject constructor(
    private val priceUiMapper: PriceUiMapper,
    private val vehicleUiMapper: VehicleUiMapper,
    private val addressUiMapper: AddressUiMapper
): Mapper<List<ActiveOrder>, List<ActiveOrderUi>> {

    override fun map(data: List<ActiveOrder>): List<ActiveOrderUi> {
        return data.map {
            ActiveOrderUi(
                id = it.id,
                startAddress = addressUiMapper.map(it.startAddress),
                endAddress = addressUiMapper.map(it.endAddress),
                price = priceUiMapper.map(it.price),
                orderTime = OrderTimeUi(it.orderTime),
                vehicle = vehicleUiMapper.map(it.vehicle)
            )
        }
    }
}