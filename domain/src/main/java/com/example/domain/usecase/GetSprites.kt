package com.example.domain.usecase

import com.example.domain.repository.GetSpritesRepository
import javax.inject.Inject

class GetSprites @Inject constructor(
    private val repository: GetSpritesRepository
) {
    suspend fun execute(name: String) = repository.getSprites(name)
}