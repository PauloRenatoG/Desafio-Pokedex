package com.example.data.mappers

import com.example.data.entities.ApiAbilityUrl
import com.example.data.util.Mapper
import com.example.domain.entity.AbilityUrl
import javax.inject.Inject

class ApiAbilityUrlToAbilityUrlMapper @Inject constructor(

) : Mapper<ApiAbilityUrl, AbilityUrl>() {
    override fun transform(input: ApiAbilityUrl) = AbilityUrl(
        name = input.name,
        url = input.url
    )
}