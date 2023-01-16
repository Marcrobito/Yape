package com.yape.recipes.mvi

sealed class Action {
    data class LoadDetailAction(val id: Int) : Action()
}

sealed class HomeAction : Action() {
    data class SearchAction(val meal: String) : HomeAction()
    data class GetRandom(val region: String = "Mexican") : HomeAction()
}