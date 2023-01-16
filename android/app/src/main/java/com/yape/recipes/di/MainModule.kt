package com.yape.recipes.di

import com.yape.recipes.core.domain.datasource.RecipeDataSource
import com.yape.recipes.core.domain.repository.RecipeRepository
import com.yape.recipes.core.usecases.GetRecipeById
import com.yape.recipes.core.usecases.GetRecipeByRegion
import com.yape.recipes.core.usecases.SearchRecipes
import com.yape.recipes.data.RecipeDataSourceImpl
import com.yape.recipes.interactors.DetailInteractor
import com.yape.recipes.interactors.HomeInteractor
import com.yape.recipes.network.Network
import com.yape.recipes.network.TheMealDBApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideApi(): TheMealDBApi = Network.service

    @Provides
    @Singleton
    fun provideRecipeDataSource(api: TheMealDBApi): RecipeDataSource = RecipeDataSourceImpl(api)

    @Provides
    @Singleton
    fun provideRecipeRepository(dataSource: RecipeDataSource) = RecipeRepository(dataSource)

    @Provides
    @Singleton
    fun provideSearchRecipes(repository: RecipeRepository) = SearchRecipes(repository)

    @Provides
    @Singleton
    fun provideGetRecipeById(repository: RecipeRepository) = GetRecipeById(repository)

    @Provides
    @Singleton
    fun provideGetRecipeByRegion(repository: RecipeRepository) = GetRecipeByRegion(repository)

    @Provides
    @Singleton
    fun provideHomeInteractor(searchRecipes: SearchRecipes, getRecipeByRegion: GetRecipeByRegion) =
        HomeInteractor(searchRecipes, getRecipeByRegion)

    @Provides
    @Singleton
    fun provideDetailInteractor(getRecipeById: GetRecipeById) = DetailInteractor(getRecipeById)

}