package com.yape.recipes.network

import com.yape.recipes.core.data.responses.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TheMealDBApi {
    @GET("search.php")
    suspend fun searchMeal(
        @Query("s") meal: String
    ): SearchResponse

    @GET("lookup.php")
    suspend fun getRecipeById(
        @Query("i") id: Int
    ): SearchResponse

    @GET("filter.php")
    suspend fun getRecipeByRegion(
        @Query("a") area: String = "Mexican"
    ): SearchResponse
}
