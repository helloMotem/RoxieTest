package com.hellomotem.roxietest.data.mapper

import com.hellomotem.roxietest.data.entity.remote.PriceResponse
import com.hellomotem.roxietest.domain.entity.Price

class PriceResponseMapper : Mapper<PriceResponse, Price> {
    override fun map(data: PriceResponse): Price = Price(
        amount = data.amount,
        currency = data.currency
    )
}