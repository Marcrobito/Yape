package com.yape.recipes.interactors

import com.yape.recipes.core.usecases.GetRecipeById

class DetailInteractor(private val getRecipeById: GetRecipeById) {
    suspend fun getRecipeById(id:Int) = getRecipeById.invoke(id)
}