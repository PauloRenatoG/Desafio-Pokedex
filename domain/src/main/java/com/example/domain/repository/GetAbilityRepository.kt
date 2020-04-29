package com.example.domain.repository

import com.example.domain.entity.EffectEntries

interface GetAbilityRepository {
    suspend fun getAbility(name: String): EffectEntries?
}