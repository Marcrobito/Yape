package com.yape.recipes.interactors

import com.yape.recipes.core.usecases.GetRecipeByRegion
import com.yape.recipes.core.usecases.SearchRecipes

class HomeInteractor(
    private val searchRecipes: SearchRecipes,
    private val getRecipeByRegion: GetRecipeByRegion
) {
    suspend fun searchRecipe(meal: String) = searchRecipes.invoke(meal)
    suspend fun getRecipeByRegion(region: String = "Mexican") = getRecipeByRegion.invoke(region)
}