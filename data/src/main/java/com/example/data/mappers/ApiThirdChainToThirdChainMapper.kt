package com.example.data.mappers

import com.example.data.entities.ApiSpeciesUrl
import com.example.data.entities.ApiThirdChain
import com.example.data.util.Mapper
import com.example.domain.entity.SpeciesUrl
import com.example.domain.entity.ThirdChain
import javax.inject.Inject

class ApiThirdChainToThirdChainMapper @Inject constructor(
    private val mapperSpecies: Mapper<ApiSpeciesUrl, SpeciesUrl>
) : Mapper<ApiThirdChain, ThirdChain>() {
    override fun transform(input: ApiThirdChain) = ThirdChain(
        speciesUrl = input.speciesUrl.let(mapperSpecies::transform)
    )
}