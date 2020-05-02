package com.example.data.mappers

import com.example.data.entities.ApiType
import com.example.data.entities.ApiTypeUrl
import com.example.data.util.Mapper
import com.example.domain.entity.Type
import com.example.domain.entity.TypeUrl
import javax.inject.Inject

class ApiTypeToTypeMapper @Inject constructor(
    private val mapper: Mapper<ApiTypeUrl, TypeUrl>
) : Mapper<ApiType, Type>() {
    override fun transform(input: ApiType) = Type(
        slot = input.slot,
        type = input.type?.let(mapper::transform)
    )

}