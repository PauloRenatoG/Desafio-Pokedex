package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class VersionDetail(
    @SerializedName("rarity")
    val rarity: Int? = null,
    @SerializedName("version")
    val version: VersionX? = null
)