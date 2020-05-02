package com.example.data.entities

import com.google.gson.annotations.SerializedName

data class ApiEvolution(
    @SerializedName("chain")
    val chain: ApiChain? = null
)