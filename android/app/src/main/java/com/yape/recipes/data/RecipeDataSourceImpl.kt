package com.yape.recipes.data

import com.yape.recipes.core.data.mapper.toRecipe
import com.yape.recipes.core.data.mapper.toRecipeList
import com.yape.recipes.core.domain.datasource.RecipeDataSource
import com.yape.recipes.core.domain.model.Recipe
import com.yape.recipes.core.domain.model.Response
import com.yape.recipes.network.TheMealDBApi

class RecipeDataSourceImpl(private val api: TheMealDBApi) : RecipeDataSource {

    override suspend fun getRecipes(meal: String): Response<List<Recipe>> {
        return try {
            with(api.searchMeal(meal).data) {
                println(this)
                if (this.isNullOrEmpty()) Response.Error(Exception("Recipe not found"))
                Response.Success(this!!.toRecipeList())
            }
        } catch (e: Exception) {
            println(e)
            Response.Error(e)
        }
    }

    override suspend fun getRecipeById(id: Int): Response<Recipe> {
        return try {
            with(api.getRecipeById(id).data) {
                if (this.isNullOrEmpty()) Response.Error(Exception("Recipe not found"))
                Response.Success(this!![0].toRecipe())
            }
        } catch (e: Exception) {
            Response.Error(e)
        }
    }

    override suspend fun getRecipeByRegion(region: String): Response<List<Recipe>> {
        return try {
            with(api.getRecipeByRegion(region).data) {
                if (this.isNullOrEmpty()) Response.Error(Exception("Recipe not found"))
                Response.Success(this!!.toRecipeList())
            }
        } catch (e: Exception) {
            Response.Error(e)
        }
    }
}