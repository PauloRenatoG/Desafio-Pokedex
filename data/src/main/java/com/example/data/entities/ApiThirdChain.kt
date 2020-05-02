package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class ApiThirdChain(
    @SerializedName("evolves_to")
    val evolvesTo: List<ApiChain>? = null,
    @SerializedName("species")
    val speciesUrl: ApiSpeciesUrl
)