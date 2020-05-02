package com.example.domain.repository

import com.example.domain.entity.PokemonDetail

interface GetPokemonDetailRepository {
    suspend fun getPokemonDetail(name: String): PokemonDetail?
}