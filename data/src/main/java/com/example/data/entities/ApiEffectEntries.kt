package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiEffectEntries(
    @SerializedName("effect_entries")
    val effectEntries: List<ApiEffectEntry>? = null
)