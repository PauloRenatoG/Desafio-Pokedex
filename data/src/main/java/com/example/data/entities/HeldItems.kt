package com.example.data.entities


import com.google.gson.annotations.SerializedName

data class HeldItems(
    @SerializedName("held_items")
    val heldItems: List<HeldItem>? = null
)