package com.example.data.mappers

import com.example.data.entities.ApiVersionUrl
import com.example.data.util.Mapper
import com.example.domain.entity.VersionUrl
import javax.inject.Inject

class ApiVersionUrlToVersionUrlMapper @Inject constructor(

) : Mapper<ApiVersionUrl, VersionUrl>() {
    override fun transform(input: ApiVersionUrl) = VersionUrl(
        name = input.name,
        url = input.url
    )

}