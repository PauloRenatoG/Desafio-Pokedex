package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class ApiSecondChain(
    @SerializedName("evolves_to")
    val evolvesTo: List<ApiThirdChain>? = null,
    @SerializedName("species")
    val speciesUrl: ApiSpeciesUrl
)