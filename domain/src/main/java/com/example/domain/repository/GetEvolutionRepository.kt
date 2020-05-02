package com.example.domain.repository

import com.example.domain.entity.Evolution

interface GetEvolutionRepository {
    suspend fun getEvolution(id: Int): Evolution?
}