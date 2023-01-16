package com.yape.recipes.ui.screen

import androidx.lifecycle.viewModelScope
import com.yape.recipes.base.BaseViewModel
import com.yape.recipes.interactors.DetailInteractor
import com.yape.recipes.mvi.Action.LoadDetailAction
import com.yape.recipes.mvi.State.DetailState
import kotlinx.coroutines.launch
import com.yape.recipes.core.domain.model.Response.Error
import com.yape.recipes.core.domain.model.Response.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val detailInteractor: DetailInteractor) :
    BaseViewModel<LoadDetailAction, DetailState>() {

    override val initialState: DetailState = DetailState()

    override fun userAction(action: LoadDetailAction) {
        _state.value = _state.value.copy(isLoading = true)
        viewModelScope.launch {
            val result = detailInteractor.getRecipeById(action.id)
            if (result is Error) _state.value =
                _state.value.copy(isLoading = false, error = result.error.message?:"Recipe not found")
            if(result is Success)
                _state.value = _state.value.copy(data = result.data, isLoading = false, error = null)
        }

    }
}