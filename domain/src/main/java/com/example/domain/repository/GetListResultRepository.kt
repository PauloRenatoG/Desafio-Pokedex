package com.example.domain.repository

import com.example.domain.entity.Response

interface GetListResultRepository {
    suspend fun getListPokemon(offset: Int, limit: Int): Response?
}