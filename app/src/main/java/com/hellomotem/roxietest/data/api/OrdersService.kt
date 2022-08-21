package com.hellomotem.roxietest.data.api

import retrofit2.http.GET
import retrofit2.http.Path

interface OrdersService {

    @GET("images/{imageName}")
    suspend fun getCarImage(@Path("imageName") imageName: String): Result<CarImageResponse>

    @GET("orders.json")
    suspend fun getActiveOrders(): Result<List<ActiveOrderResponse>>
}