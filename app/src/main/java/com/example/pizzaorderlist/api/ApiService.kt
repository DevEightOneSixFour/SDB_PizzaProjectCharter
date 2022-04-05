package com.example.pizzaorderlist.api

import com.example.pizzaorderlist.model.PizzaResponse
import com.example.pizzaorderlist.util.ORDER
import retrofit2.Response
import retrofit2.http.GET

//https://raw.githubusercontent.com/pgiani/KotlinTask/main/order.json
interface ApiService {
    @GET(ORDER)
    suspend fun getOrders(): Response<PizzaResponse>
}