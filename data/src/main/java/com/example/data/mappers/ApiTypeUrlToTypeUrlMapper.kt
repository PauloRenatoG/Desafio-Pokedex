package com.example.data.mappers

import com.example.data.entities.ApiTypeUrl
import com.example.data.util.Mapper
import com.example.domain.entity.TypeUrl
import javax.inject.Inject

class ApiTypeUrlToTypeUrlMapper @Inject constructor(

) : Mapper<ApiTypeUrl, TypeUrl>() {
    override fun transform(input: ApiTypeUrl) = TypeUrl(
        name = input.name,
        url = input.url
    )

}