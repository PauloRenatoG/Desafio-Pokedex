package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class StatX(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("url")
    val url: String? = null
)