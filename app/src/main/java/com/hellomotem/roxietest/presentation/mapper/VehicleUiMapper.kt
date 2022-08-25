package com.hellomotem.roxietest.presentation.mapper

import com.hellomotem.roxietest.domain.entity.Vehicle
import com.hellomotem.roxietest.presentation.entity.VehicleUi

class VehicleUiMapper: Mapper<Vehicle, VehicleUi> {
    override fun map(data: Vehicle): VehicleUi = VehicleUi(
        regNumber = data.regNumber,
        modelName = data.modelName,
        photo = data.photo,
        driverName = data.driverName
    )
}