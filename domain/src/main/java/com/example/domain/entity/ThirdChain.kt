package com.example.domain.entity

data class ThirdChain(
    val evolvesTo: List<Chain>? = null,
    val speciesUrl: SpeciesUrl
)