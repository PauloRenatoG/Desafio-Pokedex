package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiType(
    @SerializedName("slot")
    val slot: Int? = null,
    @SerializedName("type")
    val type: ApiTypeUrl? = null
)