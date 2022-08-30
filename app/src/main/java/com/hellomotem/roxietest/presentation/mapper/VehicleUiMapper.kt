package com.hellomotem.roxietest.presentation.mapper

import com.hellomotem.roxietest.domain.entity.Vehicle
import com.hellomotem.roxietest.presentation.entity.VehicleUi
import java.io.File

class VehicleUiMapper : Mapper<Vehicle, VehicleUi> {

    override fun map(data: Vehicle): VehicleUi = VehicleUi(
        regNumber = data.regNumber,
        driverName = data.driverName,
        photo = data.photo,
        modelName = data.modelName
    )
}