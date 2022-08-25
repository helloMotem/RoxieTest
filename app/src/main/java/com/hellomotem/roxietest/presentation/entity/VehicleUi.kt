package com.hellomotem.roxietest.presentation.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VehicleUi(
    val regNumber: String,
    val modelName: String,
    val photo: String,
    val driverName: String
): Parcelable
