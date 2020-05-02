package com.example.data.mappers

import com.example.data.entities.ApiMoveLearnMethodUrl
import com.example.data.util.Mapper
import com.example.domain.entity.MoveLearnMethodUrl
import javax.inject.Inject

class ApiMoveLearnMethodUrlToMoveLearnMethodUrlMapper @Inject constructor(

) : Mapper<ApiMoveLearnMethodUrl, MoveLearnMethodUrl>() {
    override fun transform(input: ApiMoveLearnMethodUrl) = MoveLearnMethodUrl(
        name = input.name,
        url = input.url
    )

}