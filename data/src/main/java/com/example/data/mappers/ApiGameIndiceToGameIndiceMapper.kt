package com.example.data.mappers

import com.example.data.entities.ApiGameIndice
import com.example.data.entities.ApiVersionUrl
import com.example.data.util.Mapper
import com.example.domain.entity.GameIndice
import com.example.domain.entity.VersionUrl
import javax.inject.Inject

class ApiGameIndiceToGameIndiceMapper @Inject constructor(
    private val mapper: Mapper<ApiVersionUrl, VersionUrl>
) : Mapper<ApiGameIndice, GameIndice>() {
    override fun transform(input: ApiGameIndice) = GameIndice(
        gameIndex = input.gameIndex,
        version = input.version?.let(mapper::transform)
    )

}