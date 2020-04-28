package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int? = null,
    @SerializedName("effort")
    val effort: Int? = null,
    @SerializedName("stat")
    val stat: StatX? = null
)