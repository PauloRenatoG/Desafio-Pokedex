package com.example.data.mappers

import com.example.data.entities.ApiStat
import com.example.data.entities.ApiStatUrl
import com.example.data.util.Mapper
import com.example.domain.entity.Stat
import com.example.domain.entity.StatUrl
import javax.inject.Inject

class ApiStatToStatMapper @Inject constructor(
    private val mapper: Mapper<ApiStatUrl, StatUrl>
) : Mapper<ApiStat, Stat>() {
    override fun transform(input: ApiStat) = Stat(
        baseStat = input.baseStat,
        effort = input.effort,
        stat = input.stat?.let(mapper::transform)
    )

}