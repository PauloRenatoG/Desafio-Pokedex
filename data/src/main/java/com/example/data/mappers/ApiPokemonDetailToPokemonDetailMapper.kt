package com.example.data.mappers

import com.example.data.entities.*
import com.example.data.util.Mapper
import com.example.domain.entity.*
import javax.inject.Inject

class ApiPokemonDetailToPokemonDetailMapper @Inject constructor(
    private val mapperSprites: Mapper<ApiPokemonDetail, Sprites>,
    private val mapperAbility: Mapper<ApiAbility, Ability>,
    private val mapperForm: Mapper<ApiFormUrl, FormUrl>,
    private val mapperGameIndice: Mapper<ApiGameIndice, GameIndice>,
    private val mapperHeldItems: Mapper<ApiHeldItems, HeldItems>,
    private val mapperMove: Mapper<ApiMove, Move>,
    private val mapperSpecies: Mapper<ApiSpeciesUrl, SpeciesUrl>,
    private val mapperStats: Mapper<ApiStat, Stat>,
    private val mapperTypes: Mapper<ApiType, Type>
) : Mapper<ApiPokemonDetail, PokemonDetail>() {
    override fun transform(input: ApiPokemonDetail) = PokemonDetail(
        abilities = input.abilities.let(mapperAbility::transformList),
        baseExperience = input.baseExperience,
        forms = input.forms.let(mapperForm::transformList),
        gameIndices = input.gameIndices.let(mapperGameIndice::transformList),
        height = input.height,
        heldItems = input.heldItems.let(mapperHeldItems::transformList),
        id = input.id,
        isDefault = input.isDefault,
        locationAreaEncounters = input.locationAreaEncounters,
        moves = input.moves.let(mapperMove::transformList),
        name = input.name,
        order = input.order,
        species = input.species?.let(mapperSpecies::transform),
        sprites = input.let(mapperSprites::transform),
        stats = input.stats.let(mapperStats::transformList),
        types = input.types.let(mapperTypes::transformList),
        weight = input.weight
    )
}