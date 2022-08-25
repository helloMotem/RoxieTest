package com.hellomotem.roxietest.data.mapper

import com.hellomotem.roxietest.data.entity.remote.AddressResponse
import com.hellomotem.roxietest.domain.entity.Address

class AddressResponseMapper : Mapper<AddressResponse, Address> {
    override fun map(data: AddressResponse): Address = Address(
        city = data.city,
        address = data.address
    )
}