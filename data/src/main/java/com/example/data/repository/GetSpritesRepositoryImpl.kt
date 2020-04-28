package com.example.data.repository

import com.example.data.client.ApiClient
import com.example.data.entities.ApiPokemonDetail
import com.example.data.util.Mapper
import com.example.domain.entity.Sprites
import com.example.domain.repository.GetSpritesRepository
import javax.inject.Inject

class GetSpritesRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val mapper: Mapper<ApiPokemonDetail, Sprites>
) : GetSpritesRepository {
    override suspend fun getSprites(name: String): Sprites? {
        return apiClient.getSprites(name)?.let(mapper::transform)
    }
}