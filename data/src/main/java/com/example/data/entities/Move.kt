package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class Move(
    @SerializedName("move")
    val move: MoveX? = null,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail>? = null
)