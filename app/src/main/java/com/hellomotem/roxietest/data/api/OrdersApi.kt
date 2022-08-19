package com.hellomotem.roxietest.data.api

import com.hellomotem.roxietest.data.entity.ActiveOrderResponse
import com.hellomotem.roxietest.data.entity.CarImageResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface OrdersApi {

    @GET("images/{imageName}")
    suspend fun getCarImage(@Path("imageName") imageName: String): Result<CarImageResponse>

    @GET("orders.json")
    suspend fun getActiveOrders(): Result<List<ActiveOrderResponse>>
}