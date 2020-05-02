package com.example.data.mappers

import com.example.data.entities.ApiVersionGroupUrl
import com.example.data.util.Mapper
import com.example.domain.entity.VersionGroupUrl
import javax.inject.Inject

class ApiVersionGroupUrlToVersionGroupUrlMapper @Inject constructor(

) : Mapper<ApiVersionGroupUrl, VersionGroupUrl>() {
    override fun transform(input: ApiVersionGroupUrl) = VersionGroupUrl(
        name = input.name,
        url = input.url
    )

}