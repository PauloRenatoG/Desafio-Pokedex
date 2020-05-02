package com.example.domain.entity

data class Chain(
    val evolvesTo: List<SecondChain>? = null,
    val speciesUrl: SpeciesUrl
)