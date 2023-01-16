package com.yape.recipes.core.usecases

import com.yape.recipes.core.domain.repository.RecipeRepository

class SearchRecipes(private val repository: RecipeRepository) {
    suspend fun invoke(meal:String) = repository.getRecipes(meal)
}