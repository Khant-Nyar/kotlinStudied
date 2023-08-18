package com.khantnyar.recyclerview.services

import com.khantnyar.recyclerview.models.CustomerApiResponse
import com.khantnyar.recyclerview.models.OrderApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiServiceInterface {
    @Headers("Content-Type:application/json")
    @GET("api/{model}/search")
    fun getAllCustomer(
        @Path("model") model: String,
        @Query("fields") fields: String = "[]",
//        @Query("limit") limit: Int,
        @Query("offset") offset: Int,
        @Query("order") order: String = "",
        @Query("domain") domain: String = "[]"
    ): Call<CustomerApiResponse>
    @Headers("Content-Type:application/json")
    @GET("api/{model}/search")
    fun getAllOrder(
        @Path("model") model: String = "sale.order",
        @Query("fields") fields: String = "[]",
//        @Query("limit") limit: Int,
        @Query("offset") offset: Int = 0,
        @Query("order") order: String = "",
        @Query("domain") domain: String = "[]"
    ):Call<OrderApiResponse>
}