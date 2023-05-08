package com.tikaani.models.food

import kotlinx.serialization.Serializable


@Serializable
data class IngredientsModel(
    val id: String = "",
    // Вес всего блюда в Граммах
    val dishWeight: Double = 1.0,
    // Калорийность всего блюда в Ккал
    val dishCalories: Double = 1.0,
    // Вес белков в Граммах
    val dishProteins: Double = 1.0,
    // Вес жиров в Граммах
    val dishFats: Double = 1.0,
    // Вес углеводов в Граммах
    val dishCarbohydrates: Double = 1.0,
)
