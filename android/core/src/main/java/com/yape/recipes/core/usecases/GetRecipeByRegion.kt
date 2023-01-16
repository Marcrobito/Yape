package com.yape.recipes.core.usecases

import com.yape.recipes.core.domain.repository.RecipeRepository

class GetRecipeByRegion(private val repository: RecipeRepository) {
    suspend fun invoke(region: String) = repository.getRecipeByRegion(region)
}