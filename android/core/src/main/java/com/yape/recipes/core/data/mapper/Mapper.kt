package com.yape.recipes.core.data.mapper

import com.yape.recipes.core.data.dto.RecipeDTO
import com.yape.recipes.core.domain.model.Ingredient
import com.yape.recipes.core.domain.model.Recipe

fun RecipeDTO.toRecipe(): Recipe {
    val ingredients = mutableListOf<Ingredient>()
    if (!ingredient1.isNullOrBlank() && !measure1.isNullOrBlank())
        ingredients.add(Ingredient(ingredient1, measure1))
    if (!ingredient2.isNullOrBlank() && !measure2.isNullOrBlank())
        ingredients.add(Ingredient(ingredient2, measure2))
    if (!ingredient3.isNullOrBlank() && !measure3.isNullOrBlank())
        ingredients.add(Ingredient(ingredient3, measure3))
    if (!ingredient4.isNullOrBlank() && !measure4.isNullOrBlank())
        ingredients.add(Ingredient(ingredient4, measure4))
    if (!ingredient5.isNullOrBlank() && !measure5.isNullOrBlank())
        ingredients.add(Ingredient(ingredient5, measure5))
    if (!ingredient6.isNullOrBlank() && !measure6.isNullOrBlank())
        ingredients.add(Ingredient(ingredient6, measure6))
    if (!ingredient7.isNullOrBlank() && !measure7.isNullOrBlank())
        ingredients.add(Ingredient(ingredient7, measure7))
    if (!ingredient8.isNullOrBlank() && !measure8.isNullOrBlank())
        ingredients.add(Ingredient(ingredient8, measure8))
    if (!ingredient9.isNullOrBlank() && !measure9.isNullOrBlank())
        ingredients.add(Ingredient(ingredient9, measure9))
    if (!ingredient10.isNullOrBlank() && !measure10.isNullOrBlank())
        ingredients.add(Ingredient(ingredient10, measure10))
    if (!ingredient11.isNullOrBlank() && !measure11.isNullOrBlank())
        ingredients.add(Ingredient(ingredient11, measure11))
    if (!ingredient12.isNullOrBlank() && !measure12.isNullOrBlank())
        ingredients.add(Ingredient(ingredient12, measure12))
    if (!ingredient13.isNullOrBlank() && !measure13.isNullOrBlank())
        ingredients.add(Ingredient(ingredient13, measure13))
    if (!ingredient14.isNullOrBlank() && !measure14.isNullOrBlank())
        ingredients.add(Ingredient(ingredient14, measure14))
    if (!ingredient15.isNullOrBlank() && !measure15.isNullOrBlank())
        ingredients.add(Ingredient(ingredient15, measure15))
    if (!ingredient16.isNullOrBlank() && !measure16.isNullOrBlank())
        ingredients.add(Ingredient(ingredient16, measure16))
    if (!ingredient17.isNullOrBlank() && !measure17.isNullOrBlank())
        ingredients.add(Ingredient(ingredient17, measure17))
    if (!ingredient18.isNullOrBlank() && !measure18.isNullOrBlank())
        ingredients.add(Ingredient(ingredient18, measure18))
    if (!ingredient19.isNullOrBlank() && !measure19.isNullOrBlank())
        ingredients.add(Ingredient(ingredient19, measure19))
    if (!ingredient20.isNullOrBlank() && !measure20.isNullOrBlank())
        ingredients.add(Ingredient(ingredient20, measure20))
    return Recipe(
        id = id,
        meal = meal,
        drink = drink,
        category = category,
        region = region?:"Unknown",
        instructions = instructions,
        thumb = thumb,
        tags = tags?.split(",") ?: emptyList(),
        youtubeVideo = youtubeVideo,
        ingredients = ingredients
    )
}

fun List<RecipeDTO>.toRecipeList() = this.map { it.toRecipe() }