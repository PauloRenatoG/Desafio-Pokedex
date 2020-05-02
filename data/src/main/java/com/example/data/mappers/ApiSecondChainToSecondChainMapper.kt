package com.example.data.mappers

import com.example.data.entities.ApiSecondChain
import com.example.data.entities.ApiSpeciesUrl
import com.example.data.entities.ApiThirdChain
import com.example.data.util.Mapper
import com.example.domain.entity.SecondChain
import com.example.domain.entity.SpeciesUrl
import com.example.domain.entity.ThirdChain
import javax.inject.Inject

class ApiSecondChainToSecondChainMapper @Inject constructor(
    private val mapper: Mapper<ApiThirdChain, ThirdChain>,
    private val mapperSpecies: Mapper<ApiSpeciesUrl, SpeciesUrl>
) : Mapper<ApiSecondChain, SecondChain>() {
    override fun transform(input: ApiSecondChain) = SecondChain(
        evolvesTo = input.evolvesTo.let(mapper::transformList),
        speciesUrl = input.speciesUrl.let(mapperSpecies::transform)
    )
}