package com.example.data.mappers

import com.example.data.entities.ApiChain
import com.example.data.entities.ApiSecondChain
import com.example.data.entities.ApiSpeciesUrl
import com.example.data.util.Mapper
import com.example.domain.entity.Chain
import com.example.domain.entity.SecondChain
import com.example.domain.entity.SpeciesUrl
import javax.inject.Inject

class ApiChainToChainMapper @Inject constructor(
    private val mapper: Mapper<ApiSecondChain, SecondChain>,
    private val mapperSpecies: Mapper<ApiSpeciesUrl, SpeciesUrl>
) : Mapper<ApiChain, Chain>() {
    override fun transform(input: ApiChain) = Chain(
        evolvesTo = input.evolvesTo.let(mapper::transformList),
        speciesUrl = input.speciesUrl.let(mapperSpecies::transform)
    )
}