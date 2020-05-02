package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiPokemon(
    @SerializedName("pokemon")
    val pokemon: ApiPokemonType? = null,
    @SerializedName("slot")
    val slot: Int? = null
)