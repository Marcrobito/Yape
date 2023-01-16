package com.yape.recipes.core.usecases

import com.yape.recipes.core.domain.repository.RecipeRepository

class GetRecipeById(private val repository: RecipeRepository) {
    suspend fun invoke(id: Int) = repository.getRecipeById(id)
}