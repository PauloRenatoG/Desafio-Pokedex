package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiHeldItem(
    @SerializedName("item")
    val item: ApiItemUrl? = null,
    @SerializedName("version_details")
    val versionDetails: List<ApiVersionDetail>? = null
)