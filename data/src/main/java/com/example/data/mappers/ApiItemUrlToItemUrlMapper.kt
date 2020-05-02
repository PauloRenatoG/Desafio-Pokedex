package com.example.data.mappers

import com.example.data.entities.ApiItemUrl
import com.example.data.util.Mapper
import com.example.domain.entity.ItemUrl
import javax.inject.Inject

class ApiItemUrlToItemUrlMapper @Inject constructor(

) : Mapper<ApiItemUrl, ItemUrl>() {
    override fun transform(input: ApiItemUrl) = ItemUrl(
        name = input.name,
        url = input.url
    )
}