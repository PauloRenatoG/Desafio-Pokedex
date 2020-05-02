package com.example.data.repository

import com.example.data.client.ApiClient
import com.example.data.entities.ApiListPokemonType
import com.example.data.util.Mapper
import com.example.domain.entity.ListPokemonType
import com.example.domain.repository.GetSamePokemonTypeRepository
import javax.inject.Inject

class GetSamePokemonTypeRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val mapper: Mapper<ApiListPokemonType, ListPokemonType>
) : GetSamePokemonTypeRepository {
    override suspend fun getSamePokemonType(name: String): ListPokemonType? {
        return apiClient.getSamePokemonTypes(name)?.let(mapper::transform)
    }

}