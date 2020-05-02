package com.example.domain.usecase

import com.example.domain.repository.GetEvolutionRepository
import javax.inject.Inject

class GetEvolution @Inject constructor(
    private val repository: GetEvolutionRepository
) {
    suspend fun execute(id: Int) = repository.getEvolution(id)
}