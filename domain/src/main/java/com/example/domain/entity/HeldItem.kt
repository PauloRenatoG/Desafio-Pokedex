package com.example.domain.entity

data class HeldItem(
    val item: ItemUrl? = null,
    val versionDetails: List<VersionDetail>? = null
)