package com.hellomotem.roxietest.data.api

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OrdersService {

    @GET("images/{imageName}")
    suspend fun getCarImage(@Path("imageName") imageName: String): Response<ResponseBody>

    @GET("orders.json")
    suspend fun getActiveOrders(): Response<List<ActiveOrderResponse>>
}