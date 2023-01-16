package com.yape.recipes.core.data.responses

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.yape.recipes.core.data.dto.RecipeDTO

@JsonClass(generateAdapter = true)
data class SearchResponse(@Json(name = "meals") val data: List<RecipeDTO>?)