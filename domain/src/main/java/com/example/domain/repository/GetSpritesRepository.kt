package com.example.domain.repository

import com.example.domain.entity.Sprites

interface GetSpritesRepository {
    suspend fun getSprites(name: String): Sprites?
}