package com.example.data.mappers

import com.example.data.entities.ApiPokemonDetail
import com.example.data.util.Mapper
import com.example.domain.entity.Sprites
import javax.inject.Inject

class ApiPokemonDetailToSpritesMapper @Inject constructor(

) : Mapper<ApiPokemonDetail, Sprites>() {
    override fun transform(input: ApiPokemonDetail) = Sprites(
        backDefault = input.sprites?.backDefault,
        backFemale = input.sprites?.backFemale,
        backShiny = input.sprites?.backShiny,
        backShinyFemale = input.sprites?.backShinyFemale,
        frontDefault = input.sprites?.frontDefault,
        frontFemale = input.sprites?.frontFemale,
        frontShiny = input.sprites?.frontShiny,
        frontShinyFemale = input.sprites?.frontShinyFemale
    )

}