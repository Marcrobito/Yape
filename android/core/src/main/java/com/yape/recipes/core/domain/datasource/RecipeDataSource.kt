package com.yape.recipes.core.domain.datasource

import com.yape.recipes.core.domain.model.Recipe
import com.yape.recipes.core.domain.model.Response

interface RecipeDataSource {
    suspend fun getRecipes(meal: String): Response<List<Recipe>>
    suspend fun getRecipeById(id: Int): Response<Recipe>
    suspend fun getRecipeByRegion(region: String): Response<List<Recipe>>
}