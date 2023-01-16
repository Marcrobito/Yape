package com.yape.recipes.ui.screen

import androidx.lifecycle.viewModelScope
import com.yape.recipes.base.BaseViewModel
import com.yape.recipes.core.domain.model.Response.Error
import com.yape.recipes.core.domain.model.Response.Success
import com.yape.recipes.interactors.HomeInteractor
import com.yape.recipes.mvi.HomeAction
import com.yape.recipes.mvi.State.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeInteractor: HomeInteractor) :
    BaseViewModel<HomeAction, HomeState>() {

    override val initialState: HomeState = HomeState()

    override fun userAction(action: HomeAction) {
        _state.value = _state.value.copy(isLoading = true, searchTerm = null)
        when (action) {
            is HomeAction.SearchAction -> searchByName(action.meal)
            is HomeAction.GetRandom -> searchByName("Chicken")
        }
    }

    private fun searchByName(name: String) {
        viewModelScope.launch {
            val result = homeInteractor.searchRecipe(name)
            if (result is Error)
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = result.error.message ?: "Recipe not found"
                )
            if (result is Success)
                _state.value =
                    _state.value.copy(
                        data = result.data,
                        isLoading = false,
                        error = null,
                        searchTerm = name
                    )
        }
    }

    private fun searchByRegion(region: String) {
        viewModelScope.launch {
            val result = homeInteractor.getRecipeByRegion(region)
            if (result is Error)
                _state.value = _state.value.copy(
                    isLoading = false,
                    error = result.error.message ?: "Recipe not found"
                )
            if (result is Success)
                _state.value =
                    _state.value.copy(
                        data = result.data,
                        isLoading = false,
                        error = null,
                        searchTerm = region
                    )
        }
    }


}