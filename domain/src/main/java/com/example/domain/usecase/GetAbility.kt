package com.example.domain.usecase

import com.example.domain.repository.GetAbilityRepository
import javax.inject.Inject

class GetAbility @Inject constructor(
    private val repository: GetAbilityRepository
) {
    suspend fun execute(name: String) = repository.getAbility(name)
}