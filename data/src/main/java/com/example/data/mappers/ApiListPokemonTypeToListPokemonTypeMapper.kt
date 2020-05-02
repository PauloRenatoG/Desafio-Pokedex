package com.example.data.mappers

import com.example.data.entities.ApiListPokemonType
import com.example.data.entities.ApiPokemon
import com.example.data.util.Mapper
import com.example.domain.entity.ListPokemonType
import com.example.domain.entity.Pokemon
import javax.inject.Inject

class ApiListPokemonTypeToListPokemonTypeMapper @Inject constructor(
    private val mapper: Mapper<ApiPokemon, Pokemon>
) : Mapper<ApiListPokemonType, ListPokemonType>() {
    override fun transform(input: ApiListPokemonType) = ListPokemonType(
        pokemon = input.pokemon.let(mapper::transformList)
    )

}