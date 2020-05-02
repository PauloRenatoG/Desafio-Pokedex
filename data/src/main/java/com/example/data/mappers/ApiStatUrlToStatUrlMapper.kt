package com.example.data.mappers

import com.example.data.entities.ApiStatUrl
import com.example.data.util.Mapper
import com.example.domain.entity.StatUrl
import javax.inject.Inject

class ApiStatUrlToStatUrlMapper @Inject constructor(

) : Mapper<ApiStatUrl, StatUrl>() {
    override fun transform(input: ApiStatUrl) = StatUrl(
        name = input.name,
        url = input.url
    )

}