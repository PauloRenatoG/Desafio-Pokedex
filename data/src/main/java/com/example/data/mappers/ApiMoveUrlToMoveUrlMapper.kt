package com.example.data.mappers

import com.example.data.entities.ApiMoveUrl
import com.example.data.util.Mapper
import com.example.domain.entity.MoveUrl
import javax.inject.Inject

class ApiMoveUrlToMoveUrlMapper @Inject constructor(

) : Mapper<ApiMoveUrl, MoveUrl>() {
    override fun transform(input: ApiMoveUrl) = MoveUrl(
        name = input.name,
        url = input.url
    )

}