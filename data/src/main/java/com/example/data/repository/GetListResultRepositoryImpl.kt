package com.example.data.repository

import com.example.data.client.ApiClient
import com.example.data.entities.ApiResponse
import com.example.data.util.Mapper
import com.example.domain.entity.Response
import com.example.domain.repository.GetListResultRepository
import javax.inject.Inject

class GetListResultRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val mapper: Mapper<ApiResponse, Response>
) : GetListResultRepository {
    override suspend fun getListPokemon(offset: Int, limit: Int): Response? {
        return apiClient.getListPokemon(offset, limit)?.let(mapper::transform)
    }
}