package com.example.data.entities

data class ApiError(
    val message: String?,
    val errors: List<String>? = null
)