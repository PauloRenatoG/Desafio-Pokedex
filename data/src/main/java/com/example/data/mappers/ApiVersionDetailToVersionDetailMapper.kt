package com.example.data.mappers

import com.example.data.entities.ApiVersionDetail
import com.example.data.entities.ApiVersionUrl
import com.example.data.util.Mapper
import com.example.domain.entity.VersionDetail
import com.example.domain.entity.VersionUrl
import javax.inject.Inject

class ApiVersionDetailToVersionDetailMapper @Inject constructor(
    private val mapper: Mapper<ApiVersionUrl, VersionUrl>
) : Mapper<ApiVersionDetail, VersionDetail>() {
    override fun transform(input: ApiVersionDetail) = VersionDetail(
        rarity = input.rarity,
        version = input.version?.let(mapper::transform)
    )
}