package com.yape.recipes.mvi

import com.yape.recipes.core.domain.model.Recipe

sealed class State {
    data class HomeState(
        val data: List<Recipe> = emptyList(),
        val isLoading: Boolean = false,
        val error: String? = null,
        val searchTerm: String? = null
    ) : State()

    data class DetailState(
        val data: Recipe? = null,
        val isLoading: Boolean = false,
        val error: String? = null,
    ) : State()
}