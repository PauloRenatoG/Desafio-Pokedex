package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiVersionDetail(
    @SerializedName("rarity")
    val rarity: Int? = null,
    @SerializedName("version")
    val version: ApiVersionUrl? = null
)