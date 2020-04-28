package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiMove(
    @SerializedName("move")
    val move: ApiMoveUrl? = null,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<ApiVersionGroupDetail>? = null
)