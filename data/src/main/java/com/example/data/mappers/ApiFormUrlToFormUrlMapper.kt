package com.example.data.mappers

import com.example.data.entities.ApiFormUrl
import com.example.data.util.Mapper
import com.example.domain.entity.FormUrl
import javax.inject.Inject

class ApiFormUrlToFormUrlMapper @Inject constructor(

) : Mapper<ApiFormUrl, FormUrl>() {
    override fun transform(input: ApiFormUrl) = FormUrl(
        name = input.name,
        url = input.url
    )
}