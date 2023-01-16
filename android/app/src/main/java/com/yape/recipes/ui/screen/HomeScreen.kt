package com.yape.recipes.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.yape.recipes.base.DETAIL_ROUTE_STRING
import com.yape.recipes.mvi.Action
import com.yape.recipes.mvi.HomeAction
import com.yape.recipes.ui.components.Loader
import com.yape.recipes.ui.components.RecipeCard

@Composable
fun HomeScreen(
    navController: NavHostController? = null,
    homeViewModel: HomeViewModel = hiltViewModel()
) {

    val state by homeViewModel.state.collectAsState()
    var recipe by remember { mutableStateOf("") }

    if(state.data.isEmpty() && state.error == null && !state.isLoading && state.searchTerm == null)
        homeViewModel.userAction(HomeAction.GetRandom())

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                TextField(value = recipe, onValueChange = {
                    recipe = it.trim()
                })
                Button(onClick = {
                    if (recipe.isNotBlank())
                        homeViewModel.userAction(HomeAction.SearchAction(recipe))
                }) {
                    Text("Search")
                }
            }
            state.error?.let { error ->
                Text(text = error)
            }
            if (state.error == null && !state.searchTerm.isNullOrBlank())
                Text(
                    modifier = Modifier.padding(bottom = 16.dp),
                    text = "${state.data.size} results found"
                )

            LazyVerticalGrid(
                modifier = Modifier.padding(bottom = 16.dp),
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(0.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.data) { recipe ->
                    RecipeCard(
                        recipe = recipe,
                        onClick = { navController?.navigate("$DETAIL_ROUTE_STRING/${recipe.id}") })
                }
            }
        }
        if (state.isLoading)
            Loader()
    }

}