package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class HeldItem(
    @SerializedName("item")
    val item: Item? = null,
    @SerializedName("version_details")
    val versionDetails: List<VersionDetail>? = null
)