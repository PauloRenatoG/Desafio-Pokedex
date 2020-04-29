package com.example.data.client

import com.example.data.entities.ApiPokemonDetail
import com.example.data.entities.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("pokemon/")
    suspend fun getListPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): Response<ApiResponse>

    @GET("pokemon/{name}/")
    suspend fun getSprites(@Path("name") name: String): Response<ApiPokemonDetail>

    @GET("pokemon/{name}/")
    suspend fun getPokemonDetail(@Path("name") name: String): Response<ApiPokemonDetail>
}