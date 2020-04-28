package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiGameIndice(
    @SerializedName("game_index")
    val gameIndex: Int? = null,
    @SerializedName("version")
    val version: ApiVersionUrl? = null
)