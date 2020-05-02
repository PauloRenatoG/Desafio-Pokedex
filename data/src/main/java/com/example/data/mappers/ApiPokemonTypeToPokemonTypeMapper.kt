package com.example.data.mappers

import com.example.data.entities.ApiPokemonType
import com.example.data.util.Mapper
import com.example.domain.entity.PokemonType
import javax.inject.Inject

class ApiPokemonTypeToPokemonTypeMapper @Inject constructor(

) : Mapper<ApiPokemonType, PokemonType>() {
    override fun transform(input: ApiPokemonType) = PokemonType(
        name = input.name,
        url = input.url
    )

}