package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiListPokemonType(
    @SerializedName("pokemon")
    val pokemon: List<ApiPokemon>? = null
)