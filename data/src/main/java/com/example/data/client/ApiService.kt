package com.example.data.client

import com.example.data.entities.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon/")
    suspend fun getListPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<ApiResponse>
}