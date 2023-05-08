package com.tikaani.models.food

import kotlinx.serialization.Serializable


@Serializable
data class ConsistModel(
    val id: String,
    val name: String,
)
