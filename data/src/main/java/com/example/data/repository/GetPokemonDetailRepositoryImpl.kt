package com.example.data.repository

import com.example.data.client.ApiClient
import com.example.data.entities.ApiPokemonDetail
import com.example.data.util.Mapper
import com.example.domain.entity.PokemonDetail
import com.example.domain.repository.GetPokemonDetailRepository
import javax.inject.Inject

class GetPokemonDetailRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val mapper: Mapper<ApiPokemonDetail, PokemonDetail>
) : GetPokemonDetailRepository {
    override suspend fun getPokemonDetail(name: String): PokemonDetail? {
        return apiClient.getPokemonDetail(name)?.let(mapper::transform)
    }
}