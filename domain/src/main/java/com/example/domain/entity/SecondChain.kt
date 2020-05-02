package com.example.domain.entity

data class SecondChain(
    val evolvesTo: List<ThirdChain>? = null,
    val speciesUrl: SpeciesUrl
)