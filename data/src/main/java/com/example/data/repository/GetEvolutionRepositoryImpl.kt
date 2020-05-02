package com.example.data.repository

import com.example.data.client.ApiClient
import com.example.data.entities.ApiEvolution
import com.example.data.util.Mapper
import com.example.domain.entity.Evolution
import com.example.domain.repository.GetEvolutionRepository
import javax.inject.Inject

class GetEvolutionRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val mapper: Mapper<ApiEvolution, Evolution>
) : GetEvolutionRepository {
    override suspend fun getEvolution(id: Int): Evolution? {
        return apiClient.getEvolution(id)?.let(mapper::transform)
    }

}