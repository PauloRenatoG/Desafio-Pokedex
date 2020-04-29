package com.example.data.mappers

import com.example.data.entities.ApiMoveLearnMethodUrl
import com.example.data.entities.ApiVersionGroupDetail
import com.example.data.entities.ApiVersionGroupUrl
import com.example.data.util.Mapper
import com.example.domain.entity.MoveLearnMethodUrl
import com.example.domain.entity.VersionGroupDetail
import com.example.domain.entity.VersionGroupUrl
import javax.inject.Inject

class ApiVersionGroupDetailToVersionGroupDetailMapper @Inject constructor(
    private val mapperMoveLearn: Mapper<ApiMoveLearnMethodUrl, MoveLearnMethodUrl>,
    private val mapperVersionGroup: Mapper<ApiVersionGroupUrl, VersionGroupUrl>
) : Mapper<ApiVersionGroupDetail, VersionGroupDetail>() {
    override fun transform(input: ApiVersionGroupDetail) = VersionGroupDetail(
        levelLearnedAt = input.levelLearnedAt,
        moveLearnMethod = input.moveLearnMethod?.let(mapperMoveLearn::transform),
        versionGroup = input.versionGroup?.let(mapperVersionGroup::transform)
    )
}