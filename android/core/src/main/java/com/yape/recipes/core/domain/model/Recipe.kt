package com.yape.recipes.core.domain.model

data class Recipe(
    val id: Int,
    val meal: String,
    val drink: String?,
    val category: String?,
    val region: String,
    val instructions: String,
    val thumb: String,
    val tags: List<String>,
    val youtubeVideo: String,
    val ingredients: List<Ingredient>
)
