package com.example.data.repository

import com.example.data.client.ApiClient
import com.example.data.entities.ApiEffectEntries
import com.example.data.util.Mapper
import com.example.domain.entity.EffectEntries
import com.example.domain.repository.GetAbilityRepository
import javax.inject.Inject

class GetAbilityRepositoryImpl @Inject constructor(
    private val apiClient: ApiClient,
    private val mapper: Mapper<ApiEffectEntries, EffectEntries>
) : GetAbilityRepository {
    override suspend fun getAbility(name: String): EffectEntries? {
        return apiClient.getAbility(name)?.let(mapper::transform)
    }
}