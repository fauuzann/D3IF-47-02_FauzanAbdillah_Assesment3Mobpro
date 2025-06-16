package com.fauzana0133.assesmentmobpro3.data

import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>

    @GET("items")
    suspend fun getItems(): List<Item>

    @POST("items")
    suspend fun addItem(@Body item: Item): Item

    @DELETE("items/{id}")
    suspend fun deleteItem(@Path("id") id: String)
}