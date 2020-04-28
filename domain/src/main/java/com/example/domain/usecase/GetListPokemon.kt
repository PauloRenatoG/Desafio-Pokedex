package com.example.domain.usecase

import com.example.domain.repository.GetListResultRepository
import javax.inject.Inject

class GetListPokemon @Inject constructor(
    private val repository: GetListResultRepository
) {
    suspend fun execute(offset: Int, limit: Int) = repository.getListPokemon(offset, limit)
}