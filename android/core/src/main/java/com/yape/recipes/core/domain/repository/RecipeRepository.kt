package com.yape.recipes.core.domain.repository

import com.yape.recipes.core.domain.datasource.RecipeDataSource

class RecipeRepository(private val dataSource: RecipeDataSource) {
    suspend fun getRecipes(meal: String) = dataSource.getRecipes(meal)
    suspend fun getRecipeById(id: Int) = dataSource.getRecipeById(id)
    suspend fun getRecipeByRegion(region: String) = dataSource.getRecipeByRegion(region)
}