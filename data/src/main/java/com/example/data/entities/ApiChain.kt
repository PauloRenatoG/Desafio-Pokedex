package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class ApiChain(
    @SerializedName("evolves_to")
    val evolvesTo: List<ApiSecondChain>? = null,
    @SerializedName("species")
    val speciesUrl: ApiSpeciesUrl
)