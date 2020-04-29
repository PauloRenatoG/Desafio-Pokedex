package com.example.domain.usecase

import com.example.domain.repository.GetPokemonDetailRepository
import javax.inject.Inject

class GetPokemonDetail @Inject constructor(
    private val repository: GetPokemonDetailRepository
) {
    suspend fun execute(name: String) = repository.getPokemonDetail(name)
}