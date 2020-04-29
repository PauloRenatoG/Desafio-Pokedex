package com.example.data.mappers

import com.example.data.entities.ApiMove
import com.example.data.entities.ApiMoveUrl
import com.example.data.entities.ApiVersionGroupDetail
import com.example.data.util.Mapper
import com.example.domain.entity.Move
import com.example.domain.entity.MoveUrl
import com.example.domain.entity.VersionGroupDetail
import javax.inject.Inject

class ApiMoveToMoveMapper @Inject constructor(
    private val mapperMoveUrl: Mapper<ApiMoveUrl, MoveUrl>,
    private val mapperVersionGroup: Mapper<ApiVersionGroupDetail, VersionGroupDetail>
) : Mapper<ApiMove, Move>() {
    override fun transform(input: ApiMove) = Move(
        move = input.move?.let(mapperMoveUrl::transform),
        versionGroupDetails = input.versionGroupDetails.let(mapperVersionGroup::transformList)
    )

}