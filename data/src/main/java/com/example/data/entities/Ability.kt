package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class Ability(
    @SerializedName("ability")
    val ability: AbilityX? = null,
    @SerializedName("is_hidden")
    val isHidden: Boolean? = null,
    @SerializedName("slot")
    val slot: Int? = null
)