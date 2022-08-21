package com.hellomotem.roxietest.data.mapper

import com.hellomotem.roxietest.data.api.VehicleResponse
import com.hellomotem.roxietest.domain.entity.Vehicle

class VehicleResponseMapper : Mapper<VehicleResponse, Vehicle> {
    override fun map(data: VehicleResponse): Vehicle = Vehicle(
        regNumber = data.regNumber,
        modelName = data.modelName,
        photo = data.photo,
        driverName = data.driverName
    )
}