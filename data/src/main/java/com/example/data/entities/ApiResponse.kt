package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("count")
    val count: Int? = null,
    @SerializedName("next")
    val next: String? = null,
    @SerializedName("previous")
    val previous: Any? = null,
    @SerializedName("results")
    val results: List<ApiResponseResult>? = null
)