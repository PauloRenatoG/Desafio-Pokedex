package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiEffectEntry(
    @SerializedName("effect")
    val effect: String? = null,
    @SerializedName("short_effect")
    val shortEffect: String? = null
)