package com.example.domain.usecase

import com.example.domain.repository.GetSamePokemonTypeRepository
import javax.inject.Inject

class GetSamePokemonType @Inject constructor(
    private val repository: GetSamePokemonTypeRepository
) {
    suspend fun execute(name: String) = repository.getSamePokemonType(name)
}