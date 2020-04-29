package com.example.domain.repository

import com.example.domain.entity.ListPokemonType

interface GetSamePokemonTypeRepository {
    suspend fun getSamePokemonType(name: String): ListPokemonType?
}