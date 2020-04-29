package com.example.data.mappers

import com.example.data.entities.ApiPokemon
import com.example.data.entities.ApiPokemonType
import com.example.data.util.Mapper
import com.example.domain.entity.Pokemon
import com.example.domain.entity.PokemonType
import javax.inject.Inject

class ApiPokemonToPokemonMapper @Inject constructor(
    private val mapper: Mapper<ApiPokemonType, PokemonType>
) : Mapper<ApiPokemon, Pokemon>() {
    override fun transform(input: ApiPokemon) = Pokemon(
        pokemon = input.pokemon?.let(mapper::transform),
        slot = input.slot
    )

}