package com.example.domain.entity

data class Response(
    val count: Int? = null,
    val next: String? = null,
    val previous: Any? = null,
    val results: List<Result>? = null
)