package com.hellomotem.roxietest.data.api

import com.hellomotem.roxietest.data.entity.remote.ActiveOrderResponse
import com.hellomotem.roxietest.data.entity.remote.ActiveOrdersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OrdersService {

    @GET("images/{imageName}")
    suspend fun getCarImage(@Path("imageName") imageName: String): Result<CarImageResponse>

    @GET("orders.json")
    suspend fun getActiveOrders(): Response<List<ActiveOrderResponse>>
}