package com.example.data.mappers

import com.example.data.entities.ApiSpeciesUrl
import com.example.data.util.Mapper
import com.example.domain.entity.SpeciesUrl
import javax.inject.Inject

class ApiSpeciesUrlToSpeciesUrlMapper @Inject constructor(

) : Mapper<ApiSpeciesUrl, SpeciesUrl>() {
    override fun transform(input: ApiSpeciesUrl) = SpeciesUrl(
        name = input.name,
        url = input.url
    )

}