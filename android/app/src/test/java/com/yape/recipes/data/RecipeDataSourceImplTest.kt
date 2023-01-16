package com.yape.recipes.data

import com.yape.recipes.core.data.dto.RecipeDTO
import com.yape.recipes.core.data.responses.SearchResponse
import com.yape.recipes.core.domain.model.Response
import com.yape.recipes.network.TheMealDBApi
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import org.mockito.runners.MockitoJUnitRunner


private const val ERROR_QUERY = "error"
private const val SUCCESS_QUERY = "success"

@OptIn(ExperimentalCoroutinesApi::class)
@RunWith(MockitoJUnitRunner::class)
class RecipeDataSourceImplTest {
    private val apiMock: TheMealDBApi = mock(TheMealDBApi::class.java)
    private lateinit var recipeDataSourceImpl :RecipeDataSourceImpl
    private val recipeDTO = RecipeDTO(
        id = 5,
        meal = "test",
        instructions = "",
        thumb = "",
        youtubeVideo = ""
    )

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        runBlocking {
            `when`(apiMock.searchMeal(ERROR_QUERY)).thenReturn(SearchResponse(data = null))
            `when`(apiMock.searchMeal(SUCCESS_QUERY)).thenReturn(SearchResponse(data = listOf(recipeDTO)))
            `when`(apiMock.searchMeal(SUCCESS_QUERY).data).thenReturn(listOf(recipeDTO))
            recipeDataSourceImpl = RecipeDataSourceImpl(apiMock)
        }

    }

    @Test
    fun `test getRecipes to fail`() = runTest {
        val response = recipeDataSourceImpl.getRecipes(ERROR_QUERY)
        assert(response is Response.Error)
    }

    @Test
    fun `test getRecipes to success`() = runTest {
        val response = recipeDataSourceImpl.getRecipes(SUCCESS_QUERY)
        println(response)
        assert(response is Response.Success)

    }

}