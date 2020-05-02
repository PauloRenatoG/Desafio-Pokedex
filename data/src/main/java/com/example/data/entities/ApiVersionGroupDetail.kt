package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiVersionGroupDetail(
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int? = null,
    @SerializedName("move_learn_method")
    val moveLearnMethod: ApiMoveLearnMethodUrl? = null,
    @SerializedName("version_group")
    val versionGroup: ApiVersionGroupUrl? = null
)