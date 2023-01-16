package com.yape.recipes.base

import androidx.lifecycle.ViewModel
import com.yape.recipes.mvi.Action
import com.yape.recipes.mvi.State
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseViewModel<in T: Action,  U: State>: ViewModel() {
    protected abstract val initialState: U
    protected val _state: MutableStateFlow<U> by lazy { MutableStateFlow(initialState) }
    val state : StateFlow<U> get() = _state

    abstract fun userAction(action:T)
}