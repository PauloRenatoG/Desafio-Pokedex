package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class ApiHeldItems(
    @SerializedName("held_items")
    val heldItems: List<ApiHeldItem>? = null
)