package com.hellomotem.roxietest.presentation.mapper

import com.hellomotem.roxietest.domain.entity.Address
import com.hellomotem.roxietest.presentation.entity.AddressUi

class AddressUiMapper: Mapper<Address, AddressUi> {
    override fun map(data: Address): AddressUi = AddressUi(
        city = data.city,
        address = data.address
    )
}