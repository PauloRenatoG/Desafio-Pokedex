package com.example.domain.entity

data class PokemonDetail(
    val abilities: List<Ability>? = null,
    val baseExperience: Int? = null,
    val forms: List<FormUrl>? = null,
    val gameIndices: List<GameIndice>? = null,
    val height: Int? = null,
    val heldItems: List<HeldItems>? = null,
    val id: Int? = null,
    val isDefault: Boolean? = null,
    val locationAreaEncounters: String? = null,
    val moves: List<Move>? = null,
    val name: String? = null,
    val order: Int? = null,
    val species: SpeciesUrl? = null,
    val sprites: Sprites? = null,
    val stats: List<Stat>? = null,
    val types: List<Type>? = null,
    val weight: Int? = null
)