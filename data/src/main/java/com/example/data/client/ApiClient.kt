package com.example.data.client

import com.example.data.entities.*
import com.example.data.util.RequestHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiClient @Inject constructor(
    private val apiService: ApiService
) : RequestHandler() {

    suspend fun getListPokemon(offset: Int, limit: Int): ApiResponse? {
        return withContext(Dispatchers.IO) {
            makeRequest(apiService.getListPokemon(offset, limit))
        }
    }

    suspend fun getSprites(name: String): ApiPokemonDetail? {
        return withContext(Dispatchers.IO) {
            makeRequest(apiService.getSprites(name))
        }
    }

    suspend fun getPokemonDetail(name: String): ApiPokemonDetail? {
        return withContext(Dispatchers.IO) {
            makeRequest(apiService.getPokemonDetail(name))
        }
    }

    suspend fun getAbility(name: String): ApiEffectEntries? {
        return withContext(Dispatchers.IO) {
            makeRequest(apiService.getAbility(name))
        }
    }

    suspend fun getSamePokemonTypes(name: String): ApiListPokemonType? {
        return withContext(Dispatchers.IO) {
            makeRequest(apiService.getSamePokemonTypes(name))
        }
    }

    suspend fun getEvolution(id: Int): ApiEvolution? {
        return withContext(Dispatchers.IO) {
            makeRequest(apiService.getEvolution(id))
        }
    }
}