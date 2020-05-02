package com.example.data.mappers

import com.example.data.entities.ApiChain
import com.example.data.entities.ApiEvolution
import com.example.data.util.Mapper
import com.example.domain.entity.Chain
import com.example.domain.entity.Evolution
import javax.inject.Inject

class ApiEvolutionToEvolutionMapper @Inject constructor(
    private val mapper: Mapper<ApiChain, Chain>
) : Mapper<ApiEvolution, Evolution>() {
    override fun transform(input: ApiEvolution) = Evolution(
        chain = input.chain?.let(mapper::transform)
    )
}