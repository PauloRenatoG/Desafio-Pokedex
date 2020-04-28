package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiAbility(
    @SerializedName("ability")
    val ability: ApiAbilityUrl? = null,
    @SerializedName("is_hidden")
    val isHidden: Boolean? = null,
    @SerializedName("slot")
    val slot: Int? = null
)